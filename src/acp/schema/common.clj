(ns acp.schema.common
  "Schemas shared by more than one protocol area.

  These live below the feature namespaces (`content`, `terminal`, `tool`,
  `mcp`, `session`) so any of them can refer to the shared type without
  creating a dependency cycle."
  (:require [acp.schema-runtime :as rt]))


;; -------------------------------------------------------------------------
;; SessionId
;; -------------------------------------------------------------------------

(def SessionId
  "A unique identifier for a conversation session between a client and agent. Sessions maintain their own context, conversation history, and state, allowing multiple independent interactions with the same agent. See protocol docs: [Session ID](https://agentclientprotocol.com/protocol/v1/session-setup#session-id)"
  :string)

(defn ->SessionId
  "Create a `SessionId` value."
  [id]
  (rt/validate! #'SessionId id "SessionId"))
