(ns acp.schemas-test

  (:require [clojure.test :as test]
    [acp.schemas :as schemas]
    [acp.schema.content :as content]
    [acp.schema.terminal :as terminal]
    [acp.schema.tool :as tool]
    [malli.core :as m]
    [malli.error :as me]))


(test/deftest ->ToolKind
  (let [valid-tests ["read" "edit" "delete" "move" "search" "execute" "think" "fetch" "switch_mode" "other"]
        invalid-tests ["a" "readl" "Read" "Other"]]
    (doseq [x valid-tests] (test/is (= x (schemas/->ToolKind x))))
    (doseq [x invalid-tests] (test/is (thrown? Exception (schemas/->ToolKind x))) invalid-tests)))


;; Schemas that live in `acp.schema.*` are re-exported from this namespace so
;; callers can keep using a single `acp.schemas` import.  These tests pin that
;; seam: the alias must be the very same schema and constructor, not a copy that
;; can drift.
(test/deftest re-exported-schemas
  (test/testing "schemas alias their defining namespace"
    (doseq [[exported original]
            [[schemas/TerminalExitStatus terminal/TerminalExitStatus]
             [schemas/TerminalId terminal/TerminalId]
             [schemas/TerminalOutputResponse terminal/TerminalOutputResponse]
             [schemas/Terminal terminal/Terminal]
             [schemas/ToolKind tool/ToolKind]
             [schemas/ToolCallContent tool/ToolCallContent]
             [schemas/Role content/Role]
             [schemas/Annotations content/Annotations]
             [schemas/TextContent content/TextContent]
             [schemas/ImageContent content/ImageContent]
             [schemas/AudioContent content/AudioContent]
             [schemas/ResourceLink content/ResourceLink]
             [schemas/TextResourceContents content/TextResourceContents]
             [schemas/BlobResourceContents content/BlobResourceContents]
             [schemas/EmbeddedResourceResource content/EmbeddedResourceResource]
             [schemas/EmbeddedResource content/EmbeddedResource]
             [schemas/ContentBlock content/ContentBlock]
             [schemas/Content content/Content]
             [schemas/Diff content/Diff]]]
      (test/is (identical? exported original))))

  (test/testing "constructors alias their defining namespace"
    (doseq [[exported original]
            [[schemas/->TerminalExitStatus terminal/->TerminalExitStatus]
             [schemas/->TerminalId terminal/->TerminalId]
             [schemas/->TerminalOutputResponse terminal/->TerminalOutputResponse]
             [schemas/->Terminal terminal/->Terminal]
             [schemas/->ToolKind tool/->ToolKind]
             [schemas/->ToolCallContent tool/->ToolCallContent]
             [schemas/->Role content/->Role]
             [schemas/->Annotations content/->Annotations]
             [schemas/->TextContent content/->TextContent]
             [schemas/->ImageContent content/->ImageContent]
             [schemas/->AudioContent content/->AudioContent]
             [schemas/->ResourceLink content/->ResourceLink]
             [schemas/->TextResourceContents content/->TextResourceContents]
             [schemas/->BlobResourceContents content/->BlobResourceContents]
             [schemas/->EmbeddedResourceResource content/->EmbeddedResourceResource]
             [schemas/->EmbeddedResource content/->EmbeddedResource]
             [schemas/->ContentBlock content/->ContentBlock]
             [schemas/->Content content/->Content]
             [schemas/->Diff content/->Diff]]]
      (test/is (identical? exported original))))


;; A extracted schema that is referenced from this namespace but never defined
;; or re-exported here makes malli fail with `:malli.core/invalid-schema` at
;; validation time instead of at load time, so exercise one such reference.
(test/deftest every-referenced-schema-is-bound
  (test/testing "schemas defined here resolve their extracted references"
    (test/is (bound? #'schemas/TerminalOutputResponse))
    (test/is (m/validate schemas/ClientResponse
                        {:id "1"
                         :result {:output "hello" :truncated false}}))
    (test/is (m/validate schemas/ClientResponse
                        {:id "1"
                         :result {:output "hello"
                                  :truncated true
                                  :exitStatus {:exitCode 0}}})))))


(test/deftest extracted-schemas-compose
  (test/testing "schemas defined here validate extracted content blocks"
    (test/is (m/validate schemas/ContentChunk
                        {:content {:type "text" :text "hello"}}))
    (test/is (m/validate schemas/PromptRequest
                        {:sessionId "session-1"
                         :prompt [{:type "text" :text "hello"}]})))

  (test/testing "extracted schemas validate blocks built by this namespace"
    (test/is (m/validate schemas/ContentBlock
                        (schemas/->ContentBlock {:type "text" :text "hello"})))
    (test/is (m/validate schemas/ToolCallContent
                        (schemas/->ToolCallContent {:type "diff"
                                                    :path "notes.txt"
                                                    :newText "hello"})))
    (test/is (m/validate schemas/TextContent
                        (schemas/->TextContent "hello")))))


(test/deftest extracted-schemas-error-explanation
  (test/testing "names the extracted schema being validated"
    (let [error (me/humanize (m/explain schemas/Content {:content {:type "text"}}))]
      (test/is (some? error)))))
