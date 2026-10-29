(ns acp.schema.tool
  (:require [acp.schema-runtime :as rt]
            [acp.schema.content :as content]
            [acp.schema.terminal :as terminal]))


;; -------------------------------------------------------------------------
;; ToolKind
;; -------------------------------------------------------------------------

(def ToolKind
  "Categories of tools that can be invoked. Tool kinds help clients choose appropriate icons and optimize how they display tool execution progress. See protocol docs: [Creating](https://agentclientprotocol.com/protocol/v1/tool-calls#creating)"
  [:enum
   "read"
   "edit"
   "delete"
   "move"
   "search"
   "execute"
   "think"
   "fetch"
   "switch_mode"
   "other"])

(defn ->ToolKind
  "Create a `ToolKind` value."
  [kind]
  (rt/validate! #'ToolKind kind "ToolKind"))


;; -------------------------------------------------------------------------
;; ToolCallContent
;; -------------------------------------------------------------------------

(def ToolCallContent
  "Content produced by a tool call. Tool calls can produce different types of content including standard content blocks (text, images) or file diffs. See protocol docs: [Content](https://agentclientprotocol.com/protocol/v1/tool-calls#content)"
  [:or
   [:and [:map {:closed false} [:type [:= "content"]]] #'content/Content]
   [:and [:map {:closed false} [:type [:= "diff"]]] #'content/Diff]
   [:and [:map {:closed false} [:type [:= "terminal"]]] #'terminal/Terminal]])

(defn ->ToolCallContent
  "Create a `ToolCallContent` value."
  [content]
  (rt/validate! #'ToolCallContent content "ToolCallContent"))
