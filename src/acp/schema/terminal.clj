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


;; -------------------------------------------------------------------------
;; TerminalId
;; -------------------------------------------------------------------------

(def TerminalId
  "Typed identifier used for terminal values on the wire."
  :string)

(defn ->TerminalId
  "Create a `TerminalId` value."
  [id]
  (rt/validate! #'TerminalId id "TerminalId"))


;; -------------------------------------------------------------------------
;; Terminal
;; -------------------------------------------------------------------------

(def Terminal
  "Embed a terminal created with `terminal/create` by its id. The terminal must be added before calling `terminal/release`. See protocol docs: [Terminal](https://agentclientprotocol.com/protocol/v1/terminals)"
  [:map
   {:closed false}
   [:terminalId #'TerminalId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->Terminal
  "Create a `Terminal` value."
  (rt/make-object-constructor
    #'Terminal
    "Terminal"
    [{:key :terminalId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))
