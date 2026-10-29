(ns acp.schema.tool-test

  (:require [clojure.test :as test]
            [malli.core :as m]
            [acp.schema.tool :as tool]))


;; -------------------------------------------------------------------------
;; Helpers
;; -------------------------------------------------------------------------

(defn- returned
  "Return the map produced by calling `f`, or the `ExceptionInfo` it threw."
  [f]
  (try
    (f)
    (catch clojure.lang.ExceptionInfo e
      e)))

(def ^:private valid-kinds
  ["read" "edit" "delete" "move" "search"
   "execute" "think" "fetch" "switch_mode" "other"])

(def ^:private content-value
  {:type "content"
   :content {:type "text" :text "hello"}})

(def ^:private diff-value
  {:type "diff" :path "notes.txt" :newText "hello"})

(def ^:private terminal-value
  {:type "terminal" :terminalId "terminal-1"})


(test/deftest ToolKind-schema
  (test/testing "accepts every tool kind"
    (doseq [kind valid-kinds]
      (test/is (m/validate tool/ToolKind kind)
               (str "expected " (pr-str kind) " to be accepted"))))

  (test/testing "rejects unknown and differently-cased kinds"
    (doseq [kind ["a" "readl" "Read" "Other" "" "switch-mode" "switchMode"]]
      (test/is (not (m/validate tool/ToolKind kind))
               (str "expected " (pr-str kind) " to be rejected"))))

  (test/testing "rejects non-string values"
    (doseq [value [nil 1 1.5 :read 'read true [:read] {:kind "read"}]]
      (test/is (not (m/validate tool/ToolKind value))
               (str "expected " (pr-str value) " to be rejected")))))


(test/deftest ->ToolKind
  (test/testing "returns every valid tool kind unchanged"
    (doseq [kind valid-kinds]
      (test/is (= kind (tool/->ToolKind kind))
               (str "expected " (pr-str kind) " to round-trip"))))

  (test/testing "returns a value that satisfies the schema"
    (test/is (m/validate tool/ToolKind (tool/->ToolKind "execute"))))

  (test/testing "rejects invalid tool kinds"
    (doseq [kind ["a" "readl" "Read" "Other" "" nil 1 :read [:read]]]
      (test/is (thrown? clojure.lang.ExceptionInfo
                        (tool/->ToolKind kind))
               (str "expected kind " (pr-str kind) " to be rejected"))))

  (test/testing "requires exactly one argument"
    (test/is (thrown? clojure.lang.ArityException (tool/->ToolKind)))
    (test/is (thrown? clojure.lang.ArityException
                      (tool/->ToolKind "read" "edit"))))

  (test/testing "throws an ex-info with schema, value and errors"
    (let [e (returned #(tool/->ToolKind "a"))]
      (test/is (instance? clojure.lang.ExceptionInfo e))
      (test/is (= "a" (:value (ex-data e))))
      (test/is (false? (m/validate (:schema (ex-data e))
                                   (:value (ex-data e)))))
      (test/is (some? (:errors (ex-data e))))
      (test/is (re-find #"Invalid ToolKind" (ex-message e))))))


(test/deftest ToolCallContent-schema
  (test/testing "accepts content, diff and terminal variants"
    (test/is (m/validate tool/ToolCallContent content-value))
    (test/is (m/validate tool/ToolCallContent diff-value))
    (test/is (m/validate tool/ToolCallContent terminal-value)))

  (test/testing "accepts optional fields and metadata on each variant"
    (test/is (m/validate tool/ToolCallContent
                        {:type "content"
                         :content {:type "text" :text "hello"}
                         :_meta {:traceId "t-1"}}))
    (test/is (m/validate tool/ToolCallContent
                        {:type "diff"
                         :path "notes.txt"
                         :oldText "old"
                         :newText "new"
                         :_meta {:traceId "t-2"}}))
    (test/is (m/validate tool/ToolCallContent
                        {:type "terminal"
                         :terminalId "terminal-1"
                         :_meta {:traceId "t-3"}})))

  (test/testing "accepts extra keys (maps are open)"
    (test/is (m/validate tool/ToolCallContent
                        (assoc content-value :notInSpec true)))
    (test/is (m/validate tool/ToolCallContent
                        (assoc terminal-value :notInSpec true))))

  (test/testing "requires a known type discriminator"
    (test/is (not (m/validate tool/ToolCallContent {})))
    (test/is (not (m/validate tool/ToolCallContent {:type "unknown"})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "Content" :content {:type "text" :text "hi"}})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type nil :content {:type "text" :text "hi"}}))))

  (test/testing "rejects malformed content variants"
    (test/is (not (m/validate tool/ToolCallContent {:type "content"})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "content" :content nil})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "content" :content {:type "text"}})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "content" :content "hello"}))))

  (test/testing "rejects malformed diff variants"
    (test/is (not (m/validate tool/ToolCallContent {:type "diff"})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "diff" :path "notes.txt"})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "diff" :newText "hello"})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "diff" :path 1 :newText "hello"})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "diff" :path "notes.txt" :newText nil})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "diff"
                               :path "notes.txt"
                               :oldText 1
                               :newText "hello"}))))

  (test/testing "rejects malformed terminal variants"
    (test/is (not (m/validate tool/ToolCallContent {:type "terminal"})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "terminal" :terminalId nil})))
    (test/is (not (m/validate tool/ToolCallContent
                              {:type "terminal" :terminalId 1}))))

  (test/testing "rejects non-map values"
    (doseq [value [nil "content" :content [:content] true 42]]
      (test/is (not (m/validate tool/ToolCallContent value))
               (str "expected " (pr-str value) " to be rejected")))))


(test/deftest ->ToolCallContent
  (test/testing "returns each valid variant unchanged"
    (test/is (= content-value (tool/->ToolCallContent content-value)))
    (test/is (= diff-value (tool/->ToolCallContent diff-value)))
    (test/is (= terminal-value (tool/->ToolCallContent terminal-value))))

  (test/testing "preserves metadata and extra keys"
    (let [value {:type "content"
                 :content {:type "text" :text "hello"}
                 :_meta {:traceId "t-1"}
                 :notInSpec true}]
      (test/is (= value (tool/->ToolCallContent value)))))

  (test/testing "returns a value that satisfies the schema"
    (doseq [value [content-value diff-value terminal-value]]
      (test/is (m/validate tool/ToolCallContent
                           (tool/->ToolCallContent value)))))

  (test/testing "rejects invalid content values"
    (doseq [value [{}
                   {:type "unknown"}
                   {:type "content"}
                   {:type "content" :content {:type "text"}}
                   {:type "diff" :path "notes.txt"}
                   {:type "diff" :path 1 :newText "hello"}
                   {:type "terminal"}
                   {:type "terminal" :terminalId 1}
                   nil
                   "content"
                   [:content]]]
      (test/is (thrown? clojure.lang.ExceptionInfo
                        (tool/->ToolCallContent value))
               (str "expected " (pr-str value) " to be rejected"))))

  (test/testing "requires exactly one argument"
    (test/is (thrown? clojure.lang.ArityException (tool/->ToolCallContent)))
    (test/is (thrown? clojure.lang.ArityException
                      (tool/->ToolCallContent content-value diff-value))))

  (test/testing "throws an ex-info with schema, value and errors"
    (let [e (returned #(tool/->ToolCallContent {:type "unknown"}))]
      (test/is (instance? clojure.lang.ExceptionInfo e))
      (test/is (= {:type "unknown"} (:value (ex-data e))))
      (test/is (false? (m/validate (:schema (ex-data e))
                                   (:value (ex-data e)))))
      (test/is (some? (:errors (ex-data e))))
      (test/is (re-find #"Invalid ToolCallContent" (ex-message e))))))
