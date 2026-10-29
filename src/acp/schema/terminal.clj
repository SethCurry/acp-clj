(ns acp.schema.terminal
  (:require [acp.schema-runtime :as rt]))


;; -------------------------------------------------------------------------
;; TerminalExitStatus
;; -------------------------------------------------------------------------

(def TerminalExitStatus
  "Exit status of a terminal command."
  [:map
   {:closed false}
   [:exitCode {:optional true} [:maybe [:int {:min 0}]]]
   [:signal {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(defn ->TerminalExitStatus
  [& {:keys [exitCode signal meta]}]
  (let [value {
    :exitCode exitCode
    :signal signal
    :_meta meta
    }]
  (rt/validate! #'TerminalExitStatus value "TerminalExitStatus")))


;; -------------------------------------------------------------------------
;; TerminalOutputResponse
;; -------------------------------------------------------------------------

(def TerminalOutputResponse
  "Response containing the terminal output and exit status."
  [:map
   {:closed false}
   [:output :string]
   [:truncated :boolean]
   [:exitStatus {:optional true} [:maybe #'TerminalExitStatus]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(defn ->TerminalOutputResponse
  "Create a `TerminalOutputResponse` value."
  [output truncated & {:keys [exitStatus meta]}]
  (let [value {
    :output output
    :truncated  truncated
    :exitStatus exitStatus
    :_meta meta
    }]
  (rt/validate! #'TerminalOutputResponse value "TerminalOutputResponse")))
