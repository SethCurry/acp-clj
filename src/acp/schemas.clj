;; -------------------------------------------------------------------------
;; ACP protocol schemas for namespace acp.schemas-generated.
;;
;; Generated from acp/schema.json by `acp.schema-tools`:
;;
;;     lein run -m acp.schema-tools <path> [namespace]
;;
;; This is ordinary Clojure source, so it can be compiled, read and
;; commented.  Regenerating rewrites every form below this header; keep
;; notes that must survive in a separate file.
;; -------------------------------------------------------------------------

(ns acp.schemas
  "Malli schemas for the Agent Client Protocol.

  Generated from acp/schema.json by `acp.schema-tools`."
  (:require [acp.schema-runtime :as rt]))

;; The protocol defines a type named `Error`, so drop java.lang's
;; automatic class mapping before it becomes a var.
(when (class? (get (ns-map *ns*) 'Error))
  (ns-unmap *ns* 'Error))

;; Schemas refer to one another, so declare every name up front.
(declare
         ToolKind
         ToolCallContent
         AgentResponse
         McpServerHttp
         SessionConfigOptionCategory
         TerminalOutputResponse
         ElicitationFormCapabilities
         SetSessionConfigOptionRequest
         AuthMethod
         TextResourceContents
         ListSessionsRequest
         BooleanConfigOptionCapabilities
         Terminal
         ToolCallUpdate
         InitializeRequest
         RequestId
         CurrentModeUpdate
         SessionConfigOption
         HttpHeader
         PermissionOptionId
         ReadTextFileResponse
         MessageId
         EmbeddedResource
         ConfigOptionUpdate
         SetSessionModeRequest
         SessionId
         ListSessionsResponse
         WriteTextFileResponse
         McpServerSse
         KillTerminalRequest
         CreateElicitationRequest
         SessionConfigOptionsCapabilities
         CloseSessionRequest
         ElicitationSchemaType
         Notice
         WaitForTerminalExitRequest
         ClientSessionCapabilities
         AuthCapabilities
         WriteTextFileRequest
         ExtRequest
         LoadSessionRequest
         AuthenticateRequest
         LogoutRequest
         LoadSessionResponse
         Annotations
         IntegerPropertySchema
         TerminalExitStatus
         LogoutResponse
         SessionAdditionalDirectoriesCapabilities
         ReleaseTerminalRequest
         SessionModeState
         KillTerminalResponse
         FileSystemCapabilities
         ContentBlock
         StopReason
         ElicitationAcceptAction
         SessionResumeCapabilities
         ElicitationPropertySchema
         McpCapabilities
         ClientNotification
         NoticeSeverity
         CancelNotification
         ExtResponse
         McpServer
         SessionConfigId
         EnumOption
         McpServerStdio
         ToolCallLocation
         SessionConfigGroupId
         PermissionOption
         SetSessionConfigOptionResponse
         SelectedPermissionOutcome
         SessionConfigValueId
         SessionConfigSelectOption
         ContentChunk
         Role
         Diff
         AuthenticateResponse
         ErrorCode
         MultiSelectPropertySchema
         WaitForTerminalExitResponse
         ElicitationFormMode
         AgentRequest
         StringPropertySchema
         ToolCallStatus
         ResourceLink
         StringMultiSelectItems
         ElicitationSchema
         AvailableCommandInput
         PlanEntryStatus
         UsageUpdate
         InitializeResponse
         NumberPropertySchema
         ElicitationUrlMode
         PromptResponse
         CompleteElicitationNotification
         ToolCall
         Plan
         ProtocolVersion
         AudioContent
         SessionMode
         AvailableCommandsUpdate
         ElicitationUrlCapabilities
         EnvVariable
         CreateTerminalResponse
         SetSessionModeResponse
         BooleanPropertySchema
         AuthMethodAgent
         AgentCapabilities
         Content
         CompactionCapabilities
         ElicitationRequestScope
         SessionConfigSelect
         UnstructuredCommandInput
         SessionConfigSelectGroup
         NewSessionResponse
         CreateTerminalRequest
         PermissionOptionKind
         SessionNotification
         Implementation
         StringFormat
         CancelRequestNotification
         AuthMethodId
         ElicitationId
         CompactionId
         CompactionSummaryChunk
         MultiSelectItems
         NewSessionRequest
         AgentNotification
         NoticeCapabilities
         RequestPermissionRequest
         SessionUpdate
         TitledMultiSelectItems
         BlobResourceContents
         ResumeSessionResponse
         Cost
         SessionConfigSelectOptions
         EmbeddedResourceResource
         SessionDeleteCapabilities
         ImageContent
         ElicitationCapabilities
         TerminalOutputRequest
         SessionListCapabilities
         Error
         DeleteSessionRequest
         ElicitationSessionScope
         ReleaseTerminalResponse
         RequestPermissionResponse
         PromptCapabilities
         SessionConfigBoolean
         CompactionUpdate
         CloseSessionResponse
         ToolCallId
         SessionModeId
         PlanEntryPriority
         CompactionStatus
         DeleteSessionResponse
         SessionCloseCapabilities
         ReadTextFileRequest
         ClientResponse
         SessionInfo
         ResumeSessionRequest
         PlanEntry
         TextContent
         SessionCapabilities
         PromptRequest
         AgentAuthCapabilities
         AuthMethodTerminal
         CreateElicitationResponse
         AvailableCommand
         ElicitationContentValue
         LogoutCapabilities
         TerminalId
         SessionInfoUpdate
         ExtNotification
         ClientCapabilities
         RequestPermissionOutcome
         ClientRequest)

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

(def ->ToolKind
  "Create a `ToolKind` value."
  (rt/make-value-constructor #'ToolKind "ToolKind"))

;; -------------------------------------------------------------------------
;; ToolCallContent
;; -------------------------------------------------------------------------

(def ToolCallContent
  "Content produced by a tool call. Tool calls can produce different types of content including standard content blocks (text, images) or file diffs. See protocol docs: [Content](https://agentclientprotocol.com/protocol/v1/tool-calls#content)"
  [:or
   [:and [:map {:closed false} [:type [:= "content"]]] #'Content]
   [:and [:map {:closed false} [:type [:= "diff"]]] #'Diff]
   [:and [:map {:closed false} [:type [:= "terminal"]]] #'Terminal]])

(def ->ToolCallContent
  "Create a `ToolCallContent` value."
  (rt/make-value-constructor #'ToolCallContent "ToolCallContent"))

;; -------------------------------------------------------------------------
;; AgentResponse
;; -------------------------------------------------------------------------

(def AgentResponse
  "A JSON-RPC response object."
  [:or
   [:map
    {:closed false}
    [:id #'RequestId]
    [:result
     [:or
      #'InitializeResponse
      #'AuthenticateResponse
      #'LogoutResponse
      #'NewSessionResponse
      #'LoadSessionResponse
      #'ListSessionsResponse
      #'DeleteSessionResponse
      #'ResumeSessionResponse
      #'CloseSessionResponse
      #'SetSessionModeResponse
      #'SetSessionConfigOptionResponse
      #'PromptResponse
      #'ExtResponse]]]
   [:map {:closed false} [:id #'RequestId] [:error #'Error]]])

(def ->AgentResponse
  "Create a `AgentResponse` value."
  (rt/make-value-constructor #'AgentResponse "AgentResponse"))

;; -------------------------------------------------------------------------
;; McpServerHttp
;; -------------------------------------------------------------------------

(def McpServerHttp
  "HTTP transport configuration for MCP."
  [:map
   {:closed false}
   [:name :string]
   [:url :string]
   [:headers [:vector #'HttpHeader]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->McpServerHttp
  "Create a `McpServerHttp` value."
  (rt/make-object-constructor
    #'McpServerHttp
    "McpServerHttp"
    [{:key :name, :required? true, :nullable? false}
     {:key :url, :required? true, :nullable? false}
     {:key :headers, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionConfigOptionCategory
;; -------------------------------------------------------------------------

(def SessionConfigOptionCategory
  "Semantic category for a session configuration option. This is intended to help Clients distinguish broadly common selectors (e.g. model selector vs session mode selector vs thought/reasoning level) for UX purposes (keyboard shortcuts, icons, placement). It MUST NOT be required for correctness. Clients MUST handle missing or unknown categories gracefully. Category names beginning with `_` are free for custom use, like other ACP extension methods. Category names that do not begin with `_` are reserved for the ACP spec."
  [:or
   [:= "mode"]
   [:= "model"]
   [:= "model_config"]
   [:= "thought_level"]
   :string])

(def ->SessionConfigOptionCategory
  "Create a `SessionConfigOptionCategory` value."
  (rt/make-value-constructor
    #'SessionConfigOptionCategory
    "SessionConfigOptionCategory"))

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

(def ->TerminalOutputResponse
  "Create a `TerminalOutputResponse` value."
  (rt/make-object-constructor
    #'TerminalOutputResponse
    "TerminalOutputResponse"
    [{:key :output, :required? true, :nullable? false}
     {:key :truncated, :required? true, :nullable? false}
     {:key :exitStatus, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationFormCapabilities
;; -------------------------------------------------------------------------

(def ElicitationFormCapabilities
  "Form-based elicitation capabilities. Supplying `{}` means the client supports form-based elicitation."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ElicitationFormCapabilities
  "Create a `ElicitationFormCapabilities` value."
  (rt/make-object-constructor
    #'ElicitationFormCapabilities
    "ElicitationFormCapabilities"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SetSessionConfigOptionRequest
;; -------------------------------------------------------------------------

(def SetSessionConfigOptionRequest
  "Request parameters for setting a session configuration option."
  [:and
   [:map
    {:closed false}
    [:sessionId #'SessionId]
    [:configId #'SessionConfigId]
    [:_meta {:optional true} [:maybe [:map {:closed false}]]]]
   [:or
    [:map {:closed false} [:type [:= "boolean"]] [:value :boolean]]
    [:map {:closed false} [:value #'SessionConfigValueId]]]])

(def ->SetSessionConfigOptionRequest
  "Create a `SetSessionConfigOptionRequest` value."
  (rt/make-object-constructor
    #'SetSessionConfigOptionRequest
    "SetSessionConfigOptionRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :configId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    true))

;; -------------------------------------------------------------------------
;; AuthMethod
;; -------------------------------------------------------------------------

(def AuthMethod
  "Describes an available authentication method. The `type` field acts as the discriminator in the serialized JSON form. When no `type` is present, the method is treated as `agent`."
  [:or
   [:and
    [:map {:closed false} [:type [:= "terminal"]]]
    #'AuthMethodTerminal]
   #'AuthMethodAgent])

(def ->AuthMethod
  "Create a `AuthMethod` value."
  (rt/make-value-constructor #'AuthMethod "AuthMethod"))

;; -------------------------------------------------------------------------
;; TextResourceContents
;; -------------------------------------------------------------------------

(def TextResourceContents
  "Text-based resource contents."
  [:map
   {:closed false}
   [:mimeType {:optional true} [:maybe :string]]
   [:text :string]
   [:uri :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->TextResourceContents
  "Create a `TextResourceContents` value."
  (rt/make-object-constructor
    #'TextResourceContents
    "TextResourceContents"
    [{:key :text, :required? true, :nullable? false}
     {:key :uri, :required? true, :nullable? false}
     {:key :mimeType, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ListSessionsRequest
;; -------------------------------------------------------------------------

(def ListSessionsRequest
  "Request parameters for listing existing sessions. Only available if the Agent supports the `sessionCapabilities.list` capability."
  [:map
   {:closed false}
   [:cwd {:optional true} [:maybe :string]]
   [:cursor {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ListSessionsRequest
  "Create a `ListSessionsRequest` value."
  (rt/make-object-constructor
    #'ListSessionsRequest
    "ListSessionsRequest"
    [{:key :cwd, :required? false, :nullable? true}
     {:key :cursor, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; BooleanConfigOptionCapabilities
;; -------------------------------------------------------------------------

(def BooleanConfigOptionCapabilities
  "Capabilities for boolean session configuration options. Supplying `{}` means the client supports boolean session configuration options."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->BooleanConfigOptionCapabilities
  "Create a `BooleanConfigOptionCapabilities` value."
  (rt/make-object-constructor
    #'BooleanConfigOptionCapabilities
    "BooleanConfigOptionCapabilities"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

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

;; -------------------------------------------------------------------------
;; ToolCallUpdate
;; -------------------------------------------------------------------------

(def ToolCallUpdate
  "An update to an existing tool call. Used to report progress and results as tools execute. All fields except the tool call ID are optional - only changed fields need to be included. See protocol docs: [Updating](https://agentclientprotocol.com/protocol/v1/tool-calls#updating)"
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]
   [:content {:optional true} [:maybe [:vector #'ToolCallContent]]]
   [:name {:optional true} [:maybe :string]]
   [:toolCallId #'ToolCallId]
   [:title {:optional true} [:maybe :string]]
   [:locations {:optional true} [:maybe [:vector #'ToolCallLocation]]]
   [:rawOutput {:optional true} :any]
   [:status {:optional true} [:maybe #'ToolCallStatus]]
   [:kind {:optional true} [:maybe #'ToolKind]]
   [:rawInput {:optional true} :any]])

(def ->ToolCallUpdate
  "Create a `ToolCallUpdate` value."
  (rt/make-object-constructor
    #'ToolCallUpdate
    "ToolCallUpdate"
    [{:key :toolCallId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}
     {:key :content, :required? false, :nullable? true}
     {:key :name, :required? false, :nullable? true}
     {:key :title, :required? false, :nullable? true}
     {:key :locations, :required? false, :nullable? true}
     {:key :rawOutput, :required? false, :nullable? false}
     {:key :status, :required? false, :nullable? true}
     {:key :kind, :required? false, :nullable? true}
     {:key :rawInput, :required? false, :nullable? false}]
    false))

;; -------------------------------------------------------------------------
;; InitializeRequest
;; -------------------------------------------------------------------------

(def InitializeRequest
  "Request parameters for the initialize method. Sent by the client to establish connection and negotiate capabilities. See protocol docs: [Initialization](https://agentclientprotocol.com/protocol/v1/initialization)"
  [:map
   {:closed false}
   [:protocolVersion #'ProtocolVersion]
   [:clientCapabilities {:optional true} #'ClientCapabilities]
   [:clientInfo {:optional true} [:maybe #'Implementation]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->InitializeRequest
  "Create a `InitializeRequest` value."
  (rt/make-object-constructor
    #'InitializeRequest
    "InitializeRequest"
    [{:key :protocolVersion, :required? true, :nullable? false}
     {:key :clientCapabilities, :required? false, :nullable? false}
     {:key :clientInfo, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; RequestId
;; -------------------------------------------------------------------------

(def RequestId
  "JSON RPC Request Id An identifier established by the Client that MUST contain a String, Number, or NULL value if included. If it is not included it is assumed to be a notification. The value SHOULD normally not be Null \\[1\\] and Numbers SHOULD NOT contain fractional parts \\[2\\] The Server MUST reply with the same value in the Response object if included. This member is used to correlate the context between the two objects. \\[1\\] The use of Null as a value for the id member in a Request object is discouraged, because this specification uses a value of Null for Responses with an unknown id. Also, because JSON-RPC 1.0 uses an id value of Null for Notifications this could cause confusion in handling. \\[2\\] Fractional parts may be problematic, since many decimal fractions cannot be represented exactly as binary fractions."
  [:maybe [:or :int :string]])

(def ->RequestId
  "Create a `RequestId` value."
  (rt/make-value-constructor #'RequestId "RequestId"))

;; -------------------------------------------------------------------------
;; CurrentModeUpdate
;; -------------------------------------------------------------------------

(def CurrentModeUpdate
  "The current mode of the session has changed See protocol docs: [Session Modes](https://agentclientprotocol.com/protocol/v1/session-modes)"
  [:map
   {:closed false}
   [:currentModeId #'SessionModeId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CurrentModeUpdate
  "Create a `CurrentModeUpdate` value."
  (rt/make-object-constructor
    #'CurrentModeUpdate
    "CurrentModeUpdate"
    [{:key :currentModeId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionConfigOption
;; -------------------------------------------------------------------------

(def SessionConfigOption
  "A session configuration option selector and its current state."
  [:and
   [:map
    {:closed false}
    [:id #'SessionConfigId]
    [:name :string]
    [:description {:optional true} [:maybe :string]]
    [:category {:optional true} [:maybe #'SessionConfigOptionCategory]]
    [:_meta {:optional true} [:maybe [:map {:closed false}]]]]
   [:or
    [:and
     [:map {:closed false} [:type [:= "select"]]]
     #'SessionConfigSelect]
    [:and
     [:map {:closed false} [:type [:= "boolean"]]]
     #'SessionConfigBoolean]]])

(def ->SessionConfigOption
  "Create a `SessionConfigOption` value."
  (rt/make-object-constructor
    #'SessionConfigOption
    "SessionConfigOption"
    [{:key :id, :required? true, :nullable? false}
     {:key :name, :required? true, :nullable? false}
     {:key :description, :required? false, :nullable? true}
     {:key :category, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    true))

;; -------------------------------------------------------------------------
;; HttpHeader
;; -------------------------------------------------------------------------

(def HttpHeader
  "An HTTP header to set when making requests to the MCP server."
  [:map
   {:closed false}
   [:name :string]
   [:value :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->HttpHeader
  "Create a `HttpHeader` value."
  (rt/make-object-constructor
    #'HttpHeader
    "HttpHeader"
    [{:key :name, :required? true, :nullable? false}
     {:key :value, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; PermissionOptionId
;; -------------------------------------------------------------------------

(def PermissionOptionId
  "Unique identifier for a permission option."
  :string)

(def ->PermissionOptionId
  "Create a `PermissionOptionId` value."
  (rt/make-value-constructor #'PermissionOptionId "PermissionOptionId"))

;; -------------------------------------------------------------------------
;; ReadTextFileResponse
;; -------------------------------------------------------------------------

(def ReadTextFileResponse
  "Response containing the contents of a text file."
  [:map
   {:closed false}
   [:content :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ReadTextFileResponse
  "Create a `ReadTextFileResponse` value."
  (rt/make-object-constructor
    #'ReadTextFileResponse
    "ReadTextFileResponse"
    [{:key :content, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; MessageId
;; -------------------------------------------------------------------------

(def MessageId
  "Unique identifier for a message within a session."
  :string)

(def ->MessageId
  "Create a `MessageId` value."
  (rt/make-value-constructor #'MessageId "MessageId"))

;; -------------------------------------------------------------------------
;; EmbeddedResource
;; -------------------------------------------------------------------------

(def EmbeddedResource
  "The contents of a resource, embedded into a prompt or tool call result."
  [:map
   {:closed false}
   [:annotations {:optional true} [:maybe #'Annotations]]
   [:resource #'EmbeddedResourceResource]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->EmbeddedResource
  "Create a `EmbeddedResource` value."
  (rt/make-object-constructor
    #'EmbeddedResource
    "EmbeddedResource"
    [{:key :resource, :required? true, :nullable? false}
     {:key :annotations, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ConfigOptionUpdate
;; -------------------------------------------------------------------------

(def ConfigOptionUpdate
  "Session configuration options have been updated."
  [:map
   {:closed false}
   [:configOptions [:vector #'SessionConfigOption]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ConfigOptionUpdate
  "Create a `ConfigOptionUpdate` value."
  (rt/make-object-constructor
    #'ConfigOptionUpdate
    "ConfigOptionUpdate"
    [{:key :configOptions, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SetSessionModeRequest
;; -------------------------------------------------------------------------

(def SetSessionModeRequest
  "Request parameters for setting a session mode."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:modeId #'SessionModeId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SetSessionModeRequest
  "Create a `SetSessionModeRequest` value."
  (rt/make-object-constructor
    #'SetSessionModeRequest
    "SetSessionModeRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :modeId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionId
;; -------------------------------------------------------------------------

(def SessionId
  "A unique identifier for a conversation session between a client and agent. Sessions maintain their own context, conversation history, and state, allowing multiple independent interactions with the same agent. See protocol docs: [Session ID](https://agentclientprotocol.com/protocol/v1/session-setup#session-id)"
  :string)

(def ->SessionId
  "Create a `SessionId` value."
  (rt/make-value-constructor #'SessionId "SessionId"))

;; -------------------------------------------------------------------------
;; ListSessionsResponse
;; -------------------------------------------------------------------------

(def ListSessionsResponse
  "Response from listing sessions."
  [:map
   {:closed false}
   [:sessions [:vector #'SessionInfo]]
   [:nextCursor {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ListSessionsResponse
  "Create a `ListSessionsResponse` value."
  (rt/make-object-constructor
    #'ListSessionsResponse
    "ListSessionsResponse"
    [{:key :sessions, :required? true, :nullable? false}
     {:key :nextCursor, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; WriteTextFileResponse
;; -------------------------------------------------------------------------

(def WriteTextFileResponse
  "Response to `fs/write_text_file`"
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->WriteTextFileResponse
  "Create a `WriteTextFileResponse` value."
  (rt/make-object-constructor
    #'WriteTextFileResponse
    "WriteTextFileResponse"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; McpServerSse
;; -------------------------------------------------------------------------

(def McpServerSse
  "SSE transport configuration for MCP."
  [:map
   {:closed false}
   [:name :string]
   [:url :string]
   [:headers [:vector #'HttpHeader]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->McpServerSse
  "Create a `McpServerSse` value."
  (rt/make-object-constructor
    #'McpServerSse
    "McpServerSse"
    [{:key :name, :required? true, :nullable? false}
     {:key :url, :required? true, :nullable? false}
     {:key :headers, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; KillTerminalRequest
;; -------------------------------------------------------------------------

(def KillTerminalRequest
  "Request to kill a terminal without releasing it."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:terminalId #'TerminalId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->KillTerminalRequest
  "Create a `KillTerminalRequest` value."
  (rt/make-object-constructor
    #'KillTerminalRequest
    "KillTerminalRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :terminalId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; CreateElicitationRequest
;; -------------------------------------------------------------------------

(def CreateElicitationRequest
  "Request from the agent to elicit structured user input. The agent sends this to the client to request information from the user, either via a form or by directing them to a URL. Elicitations are tied to a session (optionally a tool call) or a request."
  [:and
   [:map
    {:closed false}
    [:message :string]
    [:_meta {:optional true} [:maybe [:map {:closed false}]]]]
   [:or
    [:and [:map {:closed false} [:mode [:= "form"]]] #'ElicitationFormMode]
    [:and [:map {:closed false} [:mode [:= "url"]]] #'ElicitationUrlMode]
    [:and
     [:map {:closed false} [:mode :string]]
     [:or #'ElicitationSessionScope #'ElicitationRequestScope]
     [:not
      [:or
       [:map {:closed false} [:mode [:= "form"]]]
       [:map {:closed false} [:mode [:= "url"]]]]]]]])

(def ->CreateElicitationRequest
  "Create a `CreateElicitationRequest` value."
  (rt/make-object-constructor
    #'CreateElicitationRequest
    "CreateElicitationRequest"
    [{:key :message, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    true))

;; -------------------------------------------------------------------------
;; SessionConfigOptionsCapabilities
;; -------------------------------------------------------------------------

(def SessionConfigOptionsCapabilities
  "Session configuration option capabilities supported by the client."
  [:map
   {:closed false}
   [:boolean {:optional true} [:maybe #'BooleanConfigOptionCapabilities]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionConfigOptionsCapabilities
  "Create a `SessionConfigOptionsCapabilities` value."
  (rt/make-object-constructor
    #'SessionConfigOptionsCapabilities
    "SessionConfigOptionsCapabilities"
    [{:key :boolean, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; CloseSessionRequest
;; -------------------------------------------------------------------------

(def CloseSessionRequest
  "Request parameters for closing an active session. If supported, the agent **must** cancel any ongoing work related to the session (treat it as if `session/cancel` was called) and then free up any resources associated with the session. Only available if the Agent supports the `sessionCapabilities.close` capability."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CloseSessionRequest
  "Create a `CloseSessionRequest` value."
  (rt/make-object-constructor
    #'CloseSessionRequest
    "CloseSessionRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationSchemaType
;; -------------------------------------------------------------------------

(def ElicitationSchemaType
  "Type discriminator for elicitation schemas."
  [:enum "object"])

(def ->ElicitationSchemaType
  "Create a `ElicitationSchemaType` value."
  (rt/make-value-constructor
    #'ElicitationSchemaType
    "ElicitationSchemaType"))

;; -------------------------------------------------------------------------
;; Notice
;; -------------------------------------------------------------------------

(def Notice
  "Fire-and-forget information for the user. Notices are live events rather than session history. Agents must not rely on a notice being received, displayed, or seen by the user. Agents MUST only send notices when the Client advertised the `session.notices` Client capability. Otherwise, Agents may use an agent message when the information should still be surfaced to the user. See RFD: [Session Notices](https://agentclientprotocol.com/rfds/session-notices)"
  [:map
   {:closed false}
   [:severity #'NoticeSeverity]
   [:title [:string {:min 1}]]
   [:description {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->Notice
  "Create a `Notice` value."
  (rt/make-object-constructor
    #'Notice
    "Notice"
    [{:key :severity, :required? true, :nullable? false}
     {:key :title, :required? true, :nullable? false}
     {:key :description, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; WaitForTerminalExitRequest
;; -------------------------------------------------------------------------

(def WaitForTerminalExitRequest
  "Request to wait for a terminal command to exit."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:terminalId #'TerminalId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->WaitForTerminalExitRequest
  "Create a `WaitForTerminalExitRequest` value."
  (rt/make-object-constructor
    #'WaitForTerminalExitRequest
    "WaitForTerminalExitRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :terminalId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ClientSessionCapabilities
;; -------------------------------------------------------------------------

(def ClientSessionCapabilities
  "Session-related capabilities supported by the client."
  [:map
   {:closed false}
   [:compaction {:optional true} [:maybe #'CompactionCapabilities]]
   [:configOptions
    {:optional true}
    [:maybe #'SessionConfigOptionsCapabilities]]
   [:notices {:optional true} [:maybe #'NoticeCapabilities]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ClientSessionCapabilities
  "Create a `ClientSessionCapabilities` value."
  (rt/make-object-constructor
    #'ClientSessionCapabilities
    "ClientSessionCapabilities"
    [{:key :compaction, :required? false, :nullable? true}
     {:key :configOptions, :required? false, :nullable? true}
     {:key :notices, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AuthCapabilities
;; -------------------------------------------------------------------------

(def AuthCapabilities
  "Authentication capabilities supported by the client. Advertised during initialization to inform the agent which authentication method types the client can handle. This governs opt-in types that require additional client-side support."
  [:map
   {:closed false}
   [:terminal {:optional true} :boolean]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AuthCapabilities
  "Create a `AuthCapabilities` value."
  (rt/make-object-constructor
    #'AuthCapabilities
    "AuthCapabilities"
    [{:key :terminal, :required? false, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; WriteTextFileRequest
;; -------------------------------------------------------------------------

(def WriteTextFileRequest
  "Request to write content to a text file. Only available if the client supports the `fs.writeTextFile` capability."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:path :string]
   [:content :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->WriteTextFileRequest
  "Create a `WriteTextFileRequest` value."
  (rt/make-object-constructor
    #'WriteTextFileRequest
    "WriteTextFileRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :path, :required? true, :nullable? false}
     {:key :content, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ExtRequest
;; -------------------------------------------------------------------------

(def ExtRequest
  "Allows for sending an arbitrary request that is not part of the ACP spec. Extension methods provide a way to add custom functionality while maintaining protocol compatibility. See protocol docs: [Extensibility](https://agentclientprotocol.com/protocol/v1/extensibility)"
  :any)

(def ->ExtRequest
  "Create a `ExtRequest` value."
  (rt/make-value-constructor #'ExtRequest "ExtRequest"))

;; -------------------------------------------------------------------------
;; LoadSessionRequest
;; -------------------------------------------------------------------------

(def LoadSessionRequest
  "Request parameters for loading an existing session. Only available if the Agent supports the `loadSession` capability. See protocol docs: [Loading Sessions](https://agentclientprotocol.com/protocol/v1/session-setup#loading-sessions)"
  [:map
   {:closed false}
   [:mcpServers [:vector #'McpServer]]
   [:cwd :string]
   [:additionalDirectories {:optional true} [:vector :string]]
   [:sessionId #'SessionId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->LoadSessionRequest
  "Create a `LoadSessionRequest` value."
  (rt/make-object-constructor
    #'LoadSessionRequest
    "LoadSessionRequest"
    [{:key :mcpServers, :required? true, :nullable? false}
     {:key :cwd, :required? true, :nullable? false}
     {:key :sessionId, :required? true, :nullable? false}
     {:key :additionalDirectories, :required? false, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AuthenticateRequest
;; -------------------------------------------------------------------------

(def AuthenticateRequest
  "Request parameters for the authenticate method. Specifies which authentication method to use."
  [:map
   {:closed false}
   [:methodId #'AuthMethodId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AuthenticateRequest
  "Create a `AuthenticateRequest` value."
  (rt/make-object-constructor
    #'AuthenticateRequest
    "AuthenticateRequest"
    [{:key :methodId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; LogoutRequest
;; -------------------------------------------------------------------------

(def LogoutRequest
  "Request parameters for the logout method. Terminates the current authenticated session."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->LogoutRequest
  "Create a `LogoutRequest` value."
  (rt/make-object-constructor
    #'LogoutRequest
    "LogoutRequest"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; LoadSessionResponse
;; -------------------------------------------------------------------------

(def LoadSessionResponse
  "Response from loading an existing session."
  [:map
   {:closed false}
   [:modes {:optional true} [:maybe #'SessionModeState]]
   [:configOptions
    {:optional true}
    [:maybe [:vector #'SessionConfigOption]]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->LoadSessionResponse
  "Create a `LoadSessionResponse` value."
  (rt/make-object-constructor
    #'LoadSessionResponse
    "LoadSessionResponse"
    [{:key :modes, :required? false, :nullable? true}
     {:key :configOptions, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; Annotations
;; -------------------------------------------------------------------------

(def Annotations
  "Optional annotations for the client. The client can use annotations to inform how objects are used or displayed"
  [:map
   {:closed false}
   [:audience {:optional true} [:maybe [:vector #'Role]]]
   [:lastModified {:optional true} [:maybe :string]]
   [:priority {:optional true} [:maybe number?]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->Annotations
  "Create a `Annotations` value."
  (rt/make-object-constructor
    #'Annotations
    "Annotations"
    [{:key :audience, :required? false, :nullable? true}
     {:key :lastModified, :required? false, :nullable? true}
     {:key :priority, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; IntegerPropertySchema
;; -------------------------------------------------------------------------

(def IntegerPropertySchema
  "Schema for integer properties in an elicitation form."
  [:map
   {:closed false}
   [:title {:optional true} [:maybe :string]]
   [:description {:optional true} [:maybe :string]]
   [:minimum {:optional true} [:maybe :int]]
   [:maximum {:optional true} [:maybe :int]]
   [:default {:optional true} [:maybe :int]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->IntegerPropertySchema
  "Create a `IntegerPropertySchema` value."
  (rt/make-object-constructor
    #'IntegerPropertySchema
    "IntegerPropertySchema"
    [{:key :title, :required? false, :nullable? true}
     {:key :description, :required? false, :nullable? true}
     {:key :minimum, :required? false, :nullable? true}
     {:key :maximum, :required? false, :nullable? true}
     {:key :default, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

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

(def ->TerminalExitStatus
  "Create a `TerminalExitStatus` value."
  (rt/make-object-constructor
    #'TerminalExitStatus
    "TerminalExitStatus"
    [{:key :exitCode, :required? false, :nullable? true}
     {:key :signal, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; LogoutResponse
;; -------------------------------------------------------------------------

(def LogoutResponse
  "Response to the `logout` method."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->LogoutResponse
  "Create a `LogoutResponse` value."
  (rt/make-object-constructor
    #'LogoutResponse
    "LogoutResponse"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionAdditionalDirectoriesCapabilities
;; -------------------------------------------------------------------------

(def SessionAdditionalDirectoriesCapabilities
  "Capabilities for additional session directories support. Supplying `{}` means the agent supports the `additionalDirectories` field on supported session lifecycle requests. Agents that also support `session/list` may return `SessionInfo.additionalDirectories` to report the complete ordered additional-root list associated with a listed session."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionAdditionalDirectoriesCapabilities
  "Create a `SessionAdditionalDirectoriesCapabilities` value."
  (rt/make-object-constructor
    #'SessionAdditionalDirectoriesCapabilities
    "SessionAdditionalDirectoriesCapabilities"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ReleaseTerminalRequest
;; -------------------------------------------------------------------------

(def ReleaseTerminalRequest
  "Request to release a terminal and free its resources."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:terminalId #'TerminalId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ReleaseTerminalRequest
  "Create a `ReleaseTerminalRequest` value."
  (rt/make-object-constructor
    #'ReleaseTerminalRequest
    "ReleaseTerminalRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :terminalId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionModeState
;; -------------------------------------------------------------------------

(def SessionModeState
  "The set of modes and the one currently active."
  [:map
   {:closed false}
   [:currentModeId #'SessionModeId]
   [:availableModes [:vector #'SessionMode]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionModeState
  "Create a `SessionModeState` value."
  (rt/make-object-constructor
    #'SessionModeState
    "SessionModeState"
    [{:key :currentModeId, :required? true, :nullable? false}
     {:key :availableModes, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; KillTerminalResponse
;; -------------------------------------------------------------------------

(def KillTerminalResponse
  "Response to `terminal/kill` method"
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->KillTerminalResponse
  "Create a `KillTerminalResponse` value."
  (rt/make-object-constructor
    #'KillTerminalResponse
    "KillTerminalResponse"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; FileSystemCapabilities
;; -------------------------------------------------------------------------

(def FileSystemCapabilities
  "File system capabilities that a client may support. See protocol docs: [FileSystem](https://agentclientprotocol.com/protocol/v1/initialization#filesystem)"
  [:map
   {:closed false}
   [:readTextFile {:optional true} :boolean]
   [:writeTextFile {:optional true} :boolean]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->FileSystemCapabilities
  "Create a `FileSystemCapabilities` value."
  (rt/make-object-constructor
    #'FileSystemCapabilities
    "FileSystemCapabilities"
    [{:key :readTextFile, :required? false, :nullable? false}
     {:key :writeTextFile, :required? false, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ContentBlock
;; -------------------------------------------------------------------------

(def ContentBlock
  "Content blocks represent displayable information in the Agent Client Protocol. They provide a structured way to handle various types of user-facing content—whether it's text from language models, images for analysis, or embedded resources for context. Content blocks appear in: - User prompts sent via `session/prompt` - Language model output streamed through `session/update` notifications - Progress updates and results from tool calls This structure is compatible with the Model Context Protocol (MCP), enabling agents to seamlessly forward content from MCP tool outputs without transformation. See protocol docs: [Content](https://agentclientprotocol.com/protocol/v1/content)"
  [:or
   [:and [:map {:closed false} [:type [:= "text"]]] #'TextContent]
   [:and [:map {:closed false} [:type [:= "image"]]] #'ImageContent]
   [:and [:map {:closed false} [:type [:= "audio"]]] #'AudioContent]
   [:and [:map {:closed false} [:type [:= "resource_link"]]] #'ResourceLink]
   [:and [:map {:closed false} [:type [:= "resource"]]] #'EmbeddedResource]])

(def ->ContentBlock
  "Create a `ContentBlock` value."
  (rt/make-value-constructor #'ContentBlock "ContentBlock"))

;; -------------------------------------------------------------------------
;; StopReason
;; -------------------------------------------------------------------------

(def StopReason
  "Reasons why an agent stops processing a prompt turn. See protocol docs: [Stop Reasons](https://agentclientprotocol.com/protocol/v1/prompt-turn#stop-reasons)"
  [:enum "end_turn" "max_tokens" "max_turn_requests" "refusal" "cancelled"])

(def ->StopReason
  "Create a `StopReason` value."
  (rt/make-value-constructor #'StopReason "StopReason"))

;; -------------------------------------------------------------------------
;; ElicitationAcceptAction
;; -------------------------------------------------------------------------

(def ElicitationAcceptAction
  "The user accepted the elicitation and provided content."
  [:map
   {:closed false}
   [:content
    {:optional true}
    [:maybe [:map-of :string #'ElicitationContentValue]]]])

(def ->ElicitationAcceptAction
  "Create a `ElicitationAcceptAction` value."
  (rt/make-object-constructor
    #'ElicitationAcceptAction
    "ElicitationAcceptAction"
    [{:key :content, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionResumeCapabilities
;; -------------------------------------------------------------------------

(def SessionResumeCapabilities
  "Capabilities for the `session/resume` method. Supplying `{}` means the agent supports resuming sessions."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionResumeCapabilities
  "Create a `SessionResumeCapabilities` value."
  (rt/make-object-constructor
    #'SessionResumeCapabilities
    "SessionResumeCapabilities"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationPropertySchema
;; -------------------------------------------------------------------------

(def ElicitationPropertySchema
  "Property schema for elicitation form fields. Each variant corresponds to a JSON Schema `\"type\"` value. Single-select enums use `type: \"string\"` with `enum` or `oneOf` set. Multi-select enums use `type: \"array\"`."
  [:or
   [:and
    [:map {:closed false} [:type [:= "string"]]]
    #'StringPropertySchema]
   [:and
    [:map {:closed false} [:type [:= "number"]]]
    #'NumberPropertySchema]
   [:and
    [:map {:closed false} [:type [:= "integer"]]]
    #'IntegerPropertySchema]
   [:and
    [:map {:closed false} [:type [:= "boolean"]]]
    #'BooleanPropertySchema]
   [:and
    [:map {:closed false} [:type [:= "array"]]]
    #'MultiSelectPropertySchema]
   [:and
    [:map {:closed false} [:type :string]]
    [:not
     [:or
      [:map {:closed false} [:type [:= "string"]]]
      [:map {:closed false} [:type [:= "number"]]]
      [:map {:closed false} [:type [:= "integer"]]]
      [:map {:closed false} [:type [:= "boolean"]]]
      [:map {:closed false} [:type [:= "array"]]]]]]])

(def ->ElicitationPropertySchema
  "Create a `ElicitationPropertySchema` value."
  (rt/make-value-constructor
    #'ElicitationPropertySchema
    "ElicitationPropertySchema"))

;; -------------------------------------------------------------------------
;; McpCapabilities
;; -------------------------------------------------------------------------

(def McpCapabilities
  "MCP capabilities supported by the agent"
  [:map
   {:closed false}
   [:http {:optional true} :boolean]
   [:sse {:optional true} :boolean]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->McpCapabilities
  "Create a `McpCapabilities` value."
  (rt/make-object-constructor
    #'McpCapabilities
    "McpCapabilities"
    [{:key :http, :required? false, :nullable? false}
     {:key :sse, :required? false, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ClientNotification
;; -------------------------------------------------------------------------

(def ClientNotification
  "A JSON-RPC notification object."
  [:map
   {:closed false}
   [:method :string]
   [:params
    {:optional true}
    [:maybe [:or #'CancelNotification #'ExtNotification]]]])

(def ->ClientNotification
  "Create a `ClientNotification` value."
  (rt/make-object-constructor
    #'ClientNotification
    "ClientNotification"
    [{:key :method, :required? true, :nullable? false}
     {:key :params, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; NoticeSeverity
;; -------------------------------------------------------------------------

(def NoticeSeverity
  "Severity hint for a session notice."
  [:or [:= "info"] [:= "warning"] [:= "error"] :string])

(def ->NoticeSeverity
  "Create a `NoticeSeverity` value."
  (rt/make-value-constructor #'NoticeSeverity "NoticeSeverity"))

;; -------------------------------------------------------------------------
;; CancelNotification
;; -------------------------------------------------------------------------

(def CancelNotification
  "Notification to cancel ongoing operations for a session. See protocol docs: [Cancellation](https://agentclientprotocol.com/protocol/v1/prompt-turn#cancellation)"
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CancelNotification
  "Create a `CancelNotification` value."
  (rt/make-object-constructor
    #'CancelNotification
    "CancelNotification"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ExtResponse
;; -------------------------------------------------------------------------

(def ExtResponse
  "Allows for sending an arbitrary response to an extension request that is not part of the ACP spec. Extension methods provide a way to add custom functionality while maintaining protocol compatibility. See protocol docs: [Extensibility](https://agentclientprotocol.com/protocol/v1/extensibility)"
  :any)

(def ->ExtResponse
  "Create a `ExtResponse` value."
  (rt/make-value-constructor #'ExtResponse "ExtResponse"))

;; -------------------------------------------------------------------------
;; McpServer
;; -------------------------------------------------------------------------

(def McpServer
  "Configuration for connecting to an MCP (Model Context Protocol) server. MCP servers provide tools and context that the agent can use when processing prompts. See protocol docs: [MCP Servers](https://agentclientprotocol.com/protocol/v1/session-setup#mcp-servers)"
  [:or
   [:and [:map {:closed false} [:type [:= "http"]]] #'McpServerHttp]
   [:and [:map {:closed false} [:type [:= "sse"]]] #'McpServerSse]
   #'McpServerStdio])

(def ->McpServer
  "Create a `McpServer` value."
  (rt/make-value-constructor #'McpServer "McpServer"))

;; -------------------------------------------------------------------------
;; SessionConfigId
;; -------------------------------------------------------------------------

(def SessionConfigId
  "Unique identifier for a session configuration option."
  :string)

(def ->SessionConfigId
  "Create a `SessionConfigId` value."
  (rt/make-value-constructor #'SessionConfigId "SessionConfigId"))

;; -------------------------------------------------------------------------
;; EnumOption
;; -------------------------------------------------------------------------

(def EnumOption
  "A titled enum option with a const value, human-readable title, and optional description."
  [:map
   {:closed false}
   [:const :string]
   [:title :string]
   [:description {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->EnumOption
  "Create a `EnumOption` value."
  (rt/make-object-constructor
    #'EnumOption
    "EnumOption"
    [{:key :const, :required? true, :nullable? false}
     {:key :title, :required? true, :nullable? false}
     {:key :description, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; McpServerStdio
;; -------------------------------------------------------------------------

(def McpServerStdio
  "Stdio transport configuration for MCP."
  [:map
   {:closed false}
   [:name :string]
   [:command :string]
   [:args [:vector :string]]
   [:env [:vector #'EnvVariable]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->McpServerStdio
  "Create a `McpServerStdio` value."
  (rt/make-object-constructor
    #'McpServerStdio
    "McpServerStdio"
    [{:key :name, :required? true, :nullable? false}
     {:key :command, :required? true, :nullable? false}
     {:key :args, :required? true, :nullable? false}
     {:key :env, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ToolCallLocation
;; -------------------------------------------------------------------------

(def ToolCallLocation
  "A file location being accessed or modified by a tool. Enables clients to implement \"follow-along\" features that track which files the agent is working with in real-time. See protocol docs: [Following the Agent](https://agentclientprotocol.com/protocol/v1/tool-calls#following-the-agent)"
  [:map
   {:closed false}
   [:path :string]
   [:line {:optional true} [:maybe [:int {:min 0}]]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ToolCallLocation
  "Create a `ToolCallLocation` value."
  (rt/make-object-constructor
    #'ToolCallLocation
    "ToolCallLocation"
    [{:key :path, :required? true, :nullable? false}
     {:key :line, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionConfigGroupId
;; -------------------------------------------------------------------------

(def SessionConfigGroupId
  "Unique identifier for a session configuration option value group."
  :string)

(def ->SessionConfigGroupId
  "Create a `SessionConfigGroupId` value."
  (rt/make-value-constructor #'SessionConfigGroupId "SessionConfigGroupId"))

;; -------------------------------------------------------------------------
;; PermissionOption
;; -------------------------------------------------------------------------

(def PermissionOption
  "An option presented to the user when requesting permission."
  [:map
   {:closed false}
   [:optionId #'PermissionOptionId]
   [:name :string]
   [:kind #'PermissionOptionKind]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->PermissionOption
  "Create a `PermissionOption` value."
  (rt/make-object-constructor
    #'PermissionOption
    "PermissionOption"
    [{:key :optionId, :required? true, :nullable? false}
     {:key :name, :required? true, :nullable? false}
     {:key :kind, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SetSessionConfigOptionResponse
;; -------------------------------------------------------------------------

(def SetSessionConfigOptionResponse
  "Response to `session/set_config_option` method."
  [:map
   {:closed false}
   [:configOptions [:vector #'SessionConfigOption]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SetSessionConfigOptionResponse
  "Create a `SetSessionConfigOptionResponse` value."
  (rt/make-object-constructor
    #'SetSessionConfigOptionResponse
    "SetSessionConfigOptionResponse"
    [{:key :configOptions, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SelectedPermissionOutcome
;; -------------------------------------------------------------------------

(def SelectedPermissionOutcome
  "The user selected one of the provided options."
  [:map
   {:closed false}
   [:optionId #'PermissionOptionId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SelectedPermissionOutcome
  "Create a `SelectedPermissionOutcome` value."
  (rt/make-object-constructor
    #'SelectedPermissionOutcome
    "SelectedPermissionOutcome"
    [{:key :optionId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionConfigValueId
;; -------------------------------------------------------------------------

(def SessionConfigValueId
  "Unique identifier for a session configuration option value."
  :string)

(def ->SessionConfigValueId
  "Create a `SessionConfigValueId` value."
  (rt/make-value-constructor #'SessionConfigValueId "SessionConfigValueId"))

;; -------------------------------------------------------------------------
;; SessionConfigSelectOption
;; -------------------------------------------------------------------------

(def SessionConfigSelectOption
  "A possible value for a session configuration option."
  [:map
   {:closed false}
   [:value #'SessionConfigValueId]
   [:name :string]
   [:description {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionConfigSelectOption
  "Create a `SessionConfigSelectOption` value."
  (rt/make-object-constructor
    #'SessionConfigSelectOption
    "SessionConfigSelectOption"
    [{:key :value, :required? true, :nullable? false}
     {:key :name, :required? true, :nullable? false}
     {:key :description, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ContentChunk
;; -------------------------------------------------------------------------

(def ContentChunk
  "A streamed item of content"
  [:map
   {:closed false}
   [:content #'ContentBlock]
   [:messageId {:optional true} [:maybe #'MessageId]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ContentChunk
  "Create a `ContentChunk` value."
  (rt/make-object-constructor
    #'ContentChunk
    "ContentChunk"
    [{:key :content, :required? true, :nullable? false}
     {:key :messageId, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; Role
;; -------------------------------------------------------------------------

(def Role
  "The sender or recipient of messages and data in a conversation."
  [:enum "assistant" "user"])

(def ->Role
  "Create a `Role` value."
  (rt/make-value-constructor #'Role "Role"))

;; -------------------------------------------------------------------------
;; Diff
;; -------------------------------------------------------------------------

(def Diff
  "A diff representing file modifications. Shows changes to files in a format suitable for display in the client UI. See protocol docs: [Content](https://agentclientprotocol.com/protocol/v1/tool-calls#content)"
  [:map
   {:closed false}
   [:path :string]
   [:oldText {:optional true} [:maybe :string]]
   [:newText :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->Diff
  "Create a `Diff` value."
  (rt/make-object-constructor
    #'Diff
    "Diff"
    [{:key :path, :required? true, :nullable? false}
     {:key :newText, :required? true, :nullable? false}
     {:key :oldText, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AuthenticateResponse
;; -------------------------------------------------------------------------

(def AuthenticateResponse
  "Response to the `authenticate` method."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AuthenticateResponse
  "Create a `AuthenticateResponse` value."
  (rt/make-object-constructor
    #'AuthenticateResponse
    "AuthenticateResponse"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ErrorCode
;; -------------------------------------------------------------------------

(def ErrorCode
  "Predefined error codes for common JSON-RPC and ACP-specific errors. Standard errors use the JSON-RPC 2.0 codes. ACP-specific errors use the JSON-RPC server-error range (-32000 to -32099), and request cancellation uses -32800 from the range LSP reserves (-32899 to -32800)."
  [:or
   [:= -32700]
   [:= -32600]
   [:= -32601]
   [:= -32602]
   [:= -32603]
   [:= -32800]
   [:= -32000]
   [:= -32002]
   :int])

(def ->ErrorCode
  "Create a `ErrorCode` value."
  (rt/make-value-constructor #'ErrorCode "ErrorCode"))

;; -------------------------------------------------------------------------
;; MultiSelectPropertySchema
;; -------------------------------------------------------------------------

(def MultiSelectPropertySchema
  "Schema for multi-select (array) properties in an elicitation form."
  [:map
   {:closed false}
   [:title {:optional true} [:maybe :string]]
   [:description {:optional true} [:maybe :string]]
   [:minItems {:optional true} [:maybe [:int {:min 0}]]]
   [:maxItems {:optional true} [:maybe [:int {:min 0}]]]
   [:items #'MultiSelectItems]
   [:default {:optional true} [:maybe [:vector :string]]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->MultiSelectPropertySchema
  "Create a `MultiSelectPropertySchema` value."
  (rt/make-object-constructor
    #'MultiSelectPropertySchema
    "MultiSelectPropertySchema"
    [{:key :items, :required? true, :nullable? false}
     {:key :title, :required? false, :nullable? true}
     {:key :description, :required? false, :nullable? true}
     {:key :minItems, :required? false, :nullable? true}
     {:key :maxItems, :required? false, :nullable? true}
     {:key :default, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; WaitForTerminalExitResponse
;; -------------------------------------------------------------------------

(def WaitForTerminalExitResponse
  "Response containing the exit status of a terminal command."
  [:map
   {:closed false}
   [:exitCode {:optional true} [:maybe [:int {:min 0}]]]
   [:signal {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->WaitForTerminalExitResponse
  "Create a `WaitForTerminalExitResponse` value."
  (rt/make-object-constructor
    #'WaitForTerminalExitResponse
    "WaitForTerminalExitResponse"
    [{:key :exitCode, :required? false, :nullable? true}
     {:key :signal, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationFormMode
;; -------------------------------------------------------------------------

(def ElicitationFormMode
  "Form-based elicitation mode where the client renders a form from the provided schema."
  [:and
   [:map {:closed false} [:requestedSchema #'ElicitationSchema]]
   [:or #'ElicitationSessionScope #'ElicitationRequestScope]])

(def ->ElicitationFormMode
  "Create a `ElicitationFormMode` value."
  (rt/make-object-constructor
    #'ElicitationFormMode
    "ElicitationFormMode"
    [{:key :requestedSchema, :required? true, :nullable? false}]
    true))

;; -------------------------------------------------------------------------
;; AgentRequest
;; -------------------------------------------------------------------------

(def AgentRequest
  "A JSON-RPC request object."
  [:map
   {:closed false}
   [:id #'RequestId]
   [:method :string]
   [:params
    {:optional true}
    [:maybe
     [:or
      #'WriteTextFileRequest
      #'ReadTextFileRequest
      #'RequestPermissionRequest
      #'CreateTerminalRequest
      #'TerminalOutputRequest
      #'ReleaseTerminalRequest
      #'WaitForTerminalExitRequest
      #'KillTerminalRequest
      #'CreateElicitationRequest
      #'ExtRequest]]]])

(def ->AgentRequest
  "Create a `AgentRequest` value."
  (rt/make-object-constructor
    #'AgentRequest
    "AgentRequest"
    [{:key :id, :required? true, :nullable? false}
     {:key :method, :required? true, :nullable? false}
     {:key :params, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; StringPropertySchema
;; -------------------------------------------------------------------------

(def StringPropertySchema
  "Schema for string properties in an elicitation form. When `enum` or `oneOf` is set, this represents a single-select enum with `\"type\": \"string\"`."
  [:map
   {:closed false}
   [:description {:optional true} [:maybe :string]]
   [:enum {:optional true} [:maybe [:vector :string]]]
   [:format {:optional true} [:maybe #'StringFormat]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]
   [:default {:optional true} [:maybe :string]]
   [:minLength {:optional true} [:maybe [:int {:min 0}]]]
   [:title {:optional true} [:maybe :string]]
   [:maxLength {:optional true} [:maybe [:int {:min 0}]]]
   [:oneOf {:optional true} [:maybe [:vector #'EnumOption]]]
   [:pattern {:optional true} [:maybe :string]]])

(def ->StringPropertySchema
  "Create a `StringPropertySchema` value."
  (rt/make-object-constructor
    #'StringPropertySchema
    "StringPropertySchema"
    [{:key :description, :required? false, :nullable? true}
     {:key :enum, :required? false, :nullable? true}
     {:key :format, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}
     {:key :default, :required? false, :nullable? true}
     {:key :minLength, :required? false, :nullable? true}
     {:key :title, :required? false, :nullable? true}
     {:key :maxLength, :required? false, :nullable? true}
     {:key :oneOf, :required? false, :nullable? true}
     {:key :pattern, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ToolCallStatus
;; -------------------------------------------------------------------------

(def ToolCallStatus
  "Execution status of a tool call. Tool calls progress through different statuses during their lifecycle. See protocol docs: [Status](https://agentclientprotocol.com/protocol/v1/tool-calls#status)"
  [:enum "pending" "in_progress" "completed" "failed"])

(def ->ToolCallStatus
  "Create a `ToolCallStatus` value."
  (rt/make-value-constructor #'ToolCallStatus "ToolCallStatus"))

;; -------------------------------------------------------------------------
;; ResourceLink
;; -------------------------------------------------------------------------

(def ResourceLink
  "A resource that the server is capable of reading, included in a prompt or tool call result."
  [:map
   {:closed false}
   [:annotations {:optional true} [:maybe #'Annotations]]
   [:description {:optional true} [:maybe :string]]
   [:mimeType {:optional true} [:maybe :string]]
   [:name :string]
   [:size {:optional true} [:maybe :int]]
   [:title {:optional true} [:maybe :string]]
   [:uri :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ResourceLink
  "Create a `ResourceLink` value."
  (rt/make-object-constructor
    #'ResourceLink
    "ResourceLink"
    [{:key :name, :required? true, :nullable? false}
     {:key :uri, :required? true, :nullable? false}
     {:key :annotations, :required? false, :nullable? true}
     {:key :description, :required? false, :nullable? true}
     {:key :mimeType, :required? false, :nullable? true}
     {:key :size, :required? false, :nullable? true}
     {:key :title, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; StringMultiSelectItems
;; -------------------------------------------------------------------------

(def StringMultiSelectItems
  "String item schema for multi-select enum properties."
  [:map
   {:closed false}
   [:enum [:vector :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->StringMultiSelectItems
  "Create a `StringMultiSelectItems` value."
  (rt/make-object-constructor
    #'StringMultiSelectItems
    "StringMultiSelectItems"
    [{:key :enum, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationSchema
;; -------------------------------------------------------------------------

(def ElicitationSchema
  "Type-safe elicitation schema for requesting structured user input. This represents a JSON Schema object with primitive-typed properties, as required by the elicitation specification."
  [:map
   {:closed false}
   [:type {:optional true} #'ElicitationSchemaType]
   [:title {:optional true} [:maybe :string]]
   [:properties
    {:optional true}
    [:map-of :string #'ElicitationPropertySchema]]
   [:required {:optional true} [:maybe [:vector :string]]]
   [:description {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ElicitationSchema
  "Create a `ElicitationSchema` value."
  (rt/make-object-constructor
    #'ElicitationSchema
    "ElicitationSchema"
    [{:key :type, :required? false, :nullable? false}
     {:key :title, :required? false, :nullable? true}
     {:key :properties, :required? false, :nullable? false}
     {:key :required, :required? false, :nullable? true}
     {:key :description, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AvailableCommandInput
;; -------------------------------------------------------------------------

(def AvailableCommandInput
  "The input specification for a command."
  #'UnstructuredCommandInput)

(def ->AvailableCommandInput
  "Create a `AvailableCommandInput` value."
  (rt/make-value-constructor
    #'AvailableCommandInput
    "AvailableCommandInput"))

;; -------------------------------------------------------------------------
;; PlanEntryStatus
;; -------------------------------------------------------------------------

(def PlanEntryStatus
  "Status of a plan entry in the execution flow. Tracks the lifecycle of each task from planning through completion. See protocol docs: [Plan Entries](https://agentclientprotocol.com/protocol/v1/agent-plan#plan-entries)"
  [:enum "pending" "in_progress" "completed"])

(def ->PlanEntryStatus
  "Create a `PlanEntryStatus` value."
  (rt/make-value-constructor #'PlanEntryStatus "PlanEntryStatus"))

;; -------------------------------------------------------------------------
;; UsageUpdate
;; -------------------------------------------------------------------------

(def UsageUpdate
  "Context window and cost update for a session."
  [:map
   {:closed false}
   [:used [:int {:min 0}]]
   [:size [:int {:min 0}]]
   [:cost {:optional true} [:maybe #'Cost]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->UsageUpdate
  "Create a `UsageUpdate` value."
  (rt/make-object-constructor
    #'UsageUpdate
    "UsageUpdate"
    [{:key :used, :required? true, :nullable? false}
     {:key :size, :required? true, :nullable? false}
     {:key :cost, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; InitializeResponse
;; -------------------------------------------------------------------------

(def InitializeResponse
  "Response to the `initialize` method. Contains the negotiated protocol version and agent capabilities. See protocol docs: [Initialization](https://agentclientprotocol.com/protocol/v1/initialization)"
  [:map
   {:closed false}
   [:protocolVersion #'ProtocolVersion]
   [:agentCapabilities {:optional true} #'AgentCapabilities]
   [:authMethods {:optional true} [:vector #'AuthMethod]]
   [:agentInfo {:optional true} [:maybe #'Implementation]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->InitializeResponse
  "Create a `InitializeResponse` value."
  (rt/make-object-constructor
    #'InitializeResponse
    "InitializeResponse"
    [{:key :protocolVersion, :required? true, :nullable? false}
     {:key :agentCapabilities, :required? false, :nullable? false}
     {:key :authMethods, :required? false, :nullable? false}
     {:key :agentInfo, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; NumberPropertySchema
;; -------------------------------------------------------------------------

(def NumberPropertySchema
  "Schema for number (floating-point) properties in an elicitation form."
  [:map
   {:closed false}
   [:title {:optional true} [:maybe :string]]
   [:description {:optional true} [:maybe :string]]
   [:minimum {:optional true} [:maybe number?]]
   [:maximum {:optional true} [:maybe number?]]
   [:default {:optional true} [:maybe number?]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->NumberPropertySchema
  "Create a `NumberPropertySchema` value."
  (rt/make-object-constructor
    #'NumberPropertySchema
    "NumberPropertySchema"
    [{:key :title, :required? false, :nullable? true}
     {:key :description, :required? false, :nullable? true}
     {:key :minimum, :required? false, :nullable? true}
     {:key :maximum, :required? false, :nullable? true}
     {:key :default, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationUrlMode
;; -------------------------------------------------------------------------

(def ElicitationUrlMode
  "URL-based elicitation mode where the client directs the user to a URL."
  [:and
   [:map {:closed false} [:elicitationId #'ElicitationId] [:url :string]]
   [:or #'ElicitationSessionScope #'ElicitationRequestScope]])

(def ->ElicitationUrlMode
  "Create a `ElicitationUrlMode` value."
  (rt/make-object-constructor
    #'ElicitationUrlMode
    "ElicitationUrlMode"
    [{:key :elicitationId, :required? true, :nullable? false}
     {:key :url, :required? true, :nullable? false}]
    true))

;; -------------------------------------------------------------------------
;; PromptResponse
;; -------------------------------------------------------------------------

(def PromptResponse
  "Response from processing a user prompt. See protocol docs: [Check for Completion](https://agentclientprotocol.com/protocol/v1/prompt-turn#4-check-for-completion)"
  [:map
   {:closed false}
   [:stopReason #'StopReason]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->PromptResponse
  "Create a `PromptResponse` value."
  (rt/make-object-constructor
    #'PromptResponse
    "PromptResponse"
    [{:key :stopReason, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; CompleteElicitationNotification
;; -------------------------------------------------------------------------

(def CompleteElicitationNotification
  "Notification sent by the agent when a URL-based elicitation is complete."
  [:map
   {:closed false}
   [:elicitationId #'ElicitationId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CompleteElicitationNotification
  "Create a `CompleteElicitationNotification` value."
  (rt/make-object-constructor
    #'CompleteElicitationNotification
    "CompleteElicitationNotification"
    [{:key :elicitationId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ToolCall
;; -------------------------------------------------------------------------

(def ToolCall
  "Represents a tool call that the language model has requested. Tool calls are actions that the agent executes on behalf of the language model, such as reading files, executing code, or fetching data from external sources. See protocol docs: [Tool Calls](https://agentclientprotocol.com/protocol/v1/tool-calls)"
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]
   [:content {:optional true} [:vector #'ToolCallContent]]
   [:name {:optional true} [:maybe :string]]
   [:toolCallId #'ToolCallId]
   [:title :string]
   [:locations {:optional true} [:vector #'ToolCallLocation]]
   [:rawOutput {:optional true} :any]
   [:status {:optional true} #'ToolCallStatus]
   [:kind {:optional true} #'ToolKind]
   [:rawInput {:optional true} :any]])

(def ->ToolCall
  "Create a `ToolCall` value."
  (rt/make-object-constructor
    #'ToolCall
    "ToolCall"
    [{:key :toolCallId, :required? true, :nullable? false}
     {:key :title, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}
     {:key :content, :required? false, :nullable? false}
     {:key :name, :required? false, :nullable? true}
     {:key :locations, :required? false, :nullable? false}
     {:key :rawOutput, :required? false, :nullable? false}
     {:key :status, :required? false, :nullable? false}
     {:key :kind, :required? false, :nullable? false}
     {:key :rawInput, :required? false, :nullable? false}]
    false))

;; -------------------------------------------------------------------------
;; Plan
;; -------------------------------------------------------------------------

(def Plan
  "An execution plan for accomplishing complex tasks. Plans consist of multiple entries representing individual tasks or goals. Agents report plans to clients to provide visibility into their execution strategy. Plans can evolve during execution as the agent discovers new requirements or completes tasks. See protocol docs: [Agent Plan](https://agentclientprotocol.com/protocol/v1/agent-plan)"
  [:map
   {:closed false}
   [:entries [:vector #'PlanEntry]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->Plan
  "Create a `Plan` value."
  (rt/make-object-constructor
    #'Plan
    "Plan"
    [{:key :entries, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ProtocolVersion
;; -------------------------------------------------------------------------

(def ProtocolVersion
  "Protocol version identifier. This version is only bumped for breaking changes. Non-breaking changes should be introduced via capabilities."
  [:int {:min 0, :max 65535}])

(def ->ProtocolVersion
  "Create a `ProtocolVersion` value."
  (rt/make-value-constructor #'ProtocolVersion "ProtocolVersion"))

;; -------------------------------------------------------------------------
;; AudioContent
;; -------------------------------------------------------------------------

(def AudioContent
  "Audio provided to or from an LLM."
  [:map
   {:closed false}
   [:annotations {:optional true} [:maybe #'Annotations]]
   [:data :string]
   [:mimeType :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AudioContent
  "Create a `AudioContent` value."
  (rt/make-object-constructor
    #'AudioContent
    "AudioContent"
    [{:key :data, :required? true, :nullable? false}
     {:key :mimeType, :required? true, :nullable? false}
     {:key :annotations, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionMode
;; -------------------------------------------------------------------------

(def SessionMode
  "A mode the agent can operate in. See protocol docs: [Session Modes](https://agentclientprotocol.com/protocol/v1/session-modes)"
  [:map
   {:closed false}
   [:id #'SessionModeId]
   [:name :string]
   [:description {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionMode
  "Create a `SessionMode` value."
  (rt/make-object-constructor
    #'SessionMode
    "SessionMode"
    [{:key :id, :required? true, :nullable? false}
     {:key :name, :required? true, :nullable? false}
     {:key :description, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AvailableCommandsUpdate
;; -------------------------------------------------------------------------

(def AvailableCommandsUpdate
  "Available commands are ready or have changed"
  [:map
   {:closed false}
   [:availableCommands [:vector #'AvailableCommand]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AvailableCommandsUpdate
  "Create a `AvailableCommandsUpdate` value."
  (rt/make-object-constructor
    #'AvailableCommandsUpdate
    "AvailableCommandsUpdate"
    [{:key :availableCommands, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationUrlCapabilities
;; -------------------------------------------------------------------------

(def ElicitationUrlCapabilities
  "URL-based elicitation capabilities. Supplying `{}` means the client supports URL-based elicitation."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ElicitationUrlCapabilities
  "Create a `ElicitationUrlCapabilities` value."
  (rt/make-object-constructor
    #'ElicitationUrlCapabilities
    "ElicitationUrlCapabilities"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; EnvVariable
;; -------------------------------------------------------------------------

(def EnvVariable
  "An environment variable to set when launching an MCP server."
  [:map
   {:closed false}
   [:name :string]
   [:value :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->EnvVariable
  "Create a `EnvVariable` value."
  (rt/make-object-constructor
    #'EnvVariable
    "EnvVariable"
    [{:key :name, :required? true, :nullable? false}
     {:key :value, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; CreateTerminalResponse
;; -------------------------------------------------------------------------

(def CreateTerminalResponse
  "Response containing the ID of the created terminal."
  [:map
   {:closed false}
   [:terminalId #'TerminalId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CreateTerminalResponse
  "Create a `CreateTerminalResponse` value."
  (rt/make-object-constructor
    #'CreateTerminalResponse
    "CreateTerminalResponse"
    [{:key :terminalId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SetSessionModeResponse
;; -------------------------------------------------------------------------

(def SetSessionModeResponse
  "Response to `session/set_mode` method."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SetSessionModeResponse
  "Create a `SetSessionModeResponse` value."
  (rt/make-object-constructor
    #'SetSessionModeResponse
    "SetSessionModeResponse"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; BooleanPropertySchema
;; -------------------------------------------------------------------------

(def BooleanPropertySchema
  "Schema for boolean properties in an elicitation form."
  [:map
   {:closed false}
   [:title {:optional true} [:maybe :string]]
   [:description {:optional true} [:maybe :string]]
   [:default {:optional true} [:maybe :boolean]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->BooleanPropertySchema
  "Create a `BooleanPropertySchema` value."
  (rt/make-object-constructor
    #'BooleanPropertySchema
    "BooleanPropertySchema"
    [{:key :title, :required? false, :nullable? true}
     {:key :description, :required? false, :nullable? true}
     {:key :default, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AuthMethodAgent
;; -------------------------------------------------------------------------

(def AuthMethodAgent
  "Agent handles authentication itself through `authenticate`. This is the default authentication method type."
  [:map
   {:closed false}
   [:id #'AuthMethodId]
   [:name :string]
   [:description {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AuthMethodAgent
  "Create a `AuthMethodAgent` value."
  (rt/make-object-constructor
    #'AuthMethodAgent
    "AuthMethodAgent"
    [{:key :id, :required? true, :nullable? false}
     {:key :name, :required? true, :nullable? false}
     {:key :description, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AgentCapabilities
;; -------------------------------------------------------------------------

(def AgentCapabilities
  "Capabilities supported by the agent. Advertised during initialization to inform the client about available features and content types. See protocol docs: [Agent Capabilities](https://agentclientprotocol.com/protocol/v1/initialization#agent-capabilities)"
  [:map
   {:closed false}
   [:loadSession {:optional true} :boolean]
   [:promptCapabilities {:optional true} #'PromptCapabilities]
   [:mcpCapabilities {:optional true} #'McpCapabilities]
   [:sessionCapabilities {:optional true} #'SessionCapabilities]
   [:auth {:optional true} #'AgentAuthCapabilities]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AgentCapabilities
  "Create a `AgentCapabilities` value."
  (rt/make-object-constructor
    #'AgentCapabilities
    "AgentCapabilities"
    [{:key :loadSession, :required? false, :nullable? false}
     {:key :promptCapabilities, :required? false, :nullable? false}
     {:key :mcpCapabilities, :required? false, :nullable? false}
     {:key :sessionCapabilities, :required? false, :nullable? false}
     {:key :auth, :required? false, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; Content
;; -------------------------------------------------------------------------

(def Content
  "Standard content block (text, images, resources)."
  [:map
   {:closed false}
   [:content #'ContentBlock]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->Content
  "Create a `Content` value."
  (rt/make-object-constructor
    #'Content
    "Content"
    [{:key :content, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; CompactionCapabilities
;; -------------------------------------------------------------------------

(def CompactionCapabilities
  "Client support for ID-addressed context compaction updates."
  [:map {:closed false}])

(def ->CompactionCapabilities
  "Create a `CompactionCapabilities` value."
  (rt/make-object-constructor
    #'CompactionCapabilities
    "CompactionCapabilities"
    []
    false))

;; -------------------------------------------------------------------------
;; ElicitationRequestScope
;; -------------------------------------------------------------------------

(def ElicitationRequestScope
  "Request-scoped elicitation, tied to a specific JSON-RPC request outside of a session (e.g., during auth/configuration phases before any session is started)."
  [:map {:closed false} [:requestId #'RequestId]])

(def ->ElicitationRequestScope
  "Create a `ElicitationRequestScope` value."
  (rt/make-object-constructor
    #'ElicitationRequestScope
    "ElicitationRequestScope"
    [{:key :requestId, :required? true, :nullable? false}]
    false))

;; -------------------------------------------------------------------------
;; SessionConfigSelect
;; -------------------------------------------------------------------------

(def SessionConfigSelect
  "A single-value selector (dropdown) session configuration option payload."
  [:map
   {:closed false}
   [:currentValue #'SessionConfigValueId]
   [:options #'SessionConfigSelectOptions]])

(def ->SessionConfigSelect
  "Create a `SessionConfigSelect` value."
  (rt/make-object-constructor
    #'SessionConfigSelect
    "SessionConfigSelect"
    [{:key :currentValue, :required? true, :nullable? false}
     {:key :options, :required? true, :nullable? false}]
    false))

;; -------------------------------------------------------------------------
;; UnstructuredCommandInput
;; -------------------------------------------------------------------------

(def UnstructuredCommandInput
  "All text that was typed after the command name is provided as input."
  [:map
   {:closed false}
   [:hint :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->UnstructuredCommandInput
  "Create a `UnstructuredCommandInput` value."
  (rt/make-object-constructor
    #'UnstructuredCommandInput
    "UnstructuredCommandInput"
    [{:key :hint, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionConfigSelectGroup
;; -------------------------------------------------------------------------

(def SessionConfigSelectGroup
  "A group of possible values for a session configuration option."
  [:map
   {:closed false}
   [:group #'SessionConfigGroupId]
   [:name :string]
   [:options [:vector #'SessionConfigSelectOption]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionConfigSelectGroup
  "Create a `SessionConfigSelectGroup` value."
  (rt/make-object-constructor
    #'SessionConfigSelectGroup
    "SessionConfigSelectGroup"
    [{:key :group, :required? true, :nullable? false}
     {:key :name, :required? true, :nullable? false}
     {:key :options, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; NewSessionResponse
;; -------------------------------------------------------------------------

(def NewSessionResponse
  "Response from creating a new session. See protocol docs: [Creating a Session](https://agentclientprotocol.com/protocol/v1/session-setup#creating-a-session)"
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:modes {:optional true} [:maybe #'SessionModeState]]
   [:configOptions
    {:optional true}
    [:maybe [:vector #'SessionConfigOption]]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->NewSessionResponse
  "Create a `NewSessionResponse` value."
  (rt/make-object-constructor
    #'NewSessionResponse
    "NewSessionResponse"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :modes, :required? false, :nullable? true}
     {:key :configOptions, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; CreateTerminalRequest
;; -------------------------------------------------------------------------

(def CreateTerminalRequest
  "Request to create a new terminal and execute a command."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:command :string]
   [:args {:optional true} [:vector :string]]
   [:env {:optional true} [:vector #'EnvVariable]]
   [:cwd {:optional true} [:maybe :string]]
   [:outputByteLimit {:optional true} [:maybe [:int {:min 0}]]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CreateTerminalRequest
  "Create a `CreateTerminalRequest` value."
  (rt/make-object-constructor
    #'CreateTerminalRequest
    "CreateTerminalRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :command, :required? true, :nullable? false}
     {:key :args, :required? false, :nullable? false}
     {:key :env, :required? false, :nullable? false}
     {:key :cwd, :required? false, :nullable? true}
     {:key :outputByteLimit, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; PermissionOptionKind
;; -------------------------------------------------------------------------

(def PermissionOptionKind
  "The type of permission option being presented to the user. Helps clients choose appropriate icons and UI treatment."
  [:enum "allow_once" "allow_always" "reject_once" "reject_always"])

(def ->PermissionOptionKind
  "Create a `PermissionOptionKind` value."
  (rt/make-value-constructor #'PermissionOptionKind "PermissionOptionKind"))

;; -------------------------------------------------------------------------
;; SessionNotification
;; -------------------------------------------------------------------------

(def SessionNotification
  "Notification containing a session update from the agent. Used to stream real-time progress and results during prompt processing. See protocol docs: [Agent Reports Output](https://agentclientprotocol.com/protocol/v1/prompt-turn#3-agent-reports-output)"
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:update #'SessionUpdate]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionNotification
  "Create a `SessionNotification` value."
  (rt/make-object-constructor
    #'SessionNotification
    "SessionNotification"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :update, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; Implementation
;; -------------------------------------------------------------------------

(def Implementation
  "Metadata about the implementation of the client or agent. Describes the name and version of an ACP implementation, with an optional title for UI representation."
  [:map
   {:closed false}
   [:name :string]
   [:title {:optional true} [:maybe :string]]
   [:version :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->Implementation
  "Create a `Implementation` value."
  (rt/make-object-constructor
    #'Implementation
    "Implementation"
    [{:key :name, :required? true, :nullable? false}
     {:key :version, :required? true, :nullable? false}
     {:key :title, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; StringFormat
;; -------------------------------------------------------------------------

(def StringFormat
  "String format types for string properties in elicitation schemas."
  [:enum "email" "uri" "date" "date-time"])

(def ->StringFormat
  "Create a `StringFormat` value."
  (rt/make-value-constructor #'StringFormat "StringFormat"))

;; -------------------------------------------------------------------------
;; CancelRequestNotification
;; -------------------------------------------------------------------------

(def CancelRequestNotification
  "Notification to cancel an ongoing request. See protocol docs: [Cancellation](https://agentclientprotocol.com/protocol/v1/cancellation)"
  [:map
   {:closed false}
   [:requestId #'RequestId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CancelRequestNotification
  "Create a `CancelRequestNotification` value."
  (rt/make-object-constructor
    #'CancelRequestNotification
    "CancelRequestNotification"
    [{:key :requestId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AuthMethodId
;; -------------------------------------------------------------------------

(def AuthMethodId
  "Typed identifier used for auth method values on the wire."
  :string)

(def ->AuthMethodId
  "Create a `AuthMethodId` value."
  (rt/make-value-constructor #'AuthMethodId "AuthMethodId"))

;; -------------------------------------------------------------------------
;; ElicitationId
;; -------------------------------------------------------------------------

(def ElicitationId
  "Unique identifier for an elicitation."
  :string)

(def ->ElicitationId
  "Create a `ElicitationId` value."
  (rt/make-value-constructor #'ElicitationId "ElicitationId"))

;; -------------------------------------------------------------------------
;; CompactionId
;; -------------------------------------------------------------------------

(def CompactionId
  "Unique identifier for a context compaction within a session."
  :string)

(def ->CompactionId
  "Create a `CompactionId` value."
  (rt/make-value-constructor #'CompactionId "CompactionId"))

;; -------------------------------------------------------------------------
;; CompactionSummaryChunk
;; -------------------------------------------------------------------------

(def CompactionSummaryChunk
  "A content block appended to a compaction's summary. A first-seen ID creates an in-progress compaction. Chunks append in receive order. Agents MUST only send this update when the Client advertised the `session.compaction` Client capability."
  [:map
   {:closed false}
   [:compactionId #'CompactionId]
   [:content #'ContentBlock]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CompactionSummaryChunk
  "Create a `CompactionSummaryChunk` value."
  (rt/make-object-constructor
    #'CompactionSummaryChunk
    "CompactionSummaryChunk"
    [{:key :compactionId, :required? true, :nullable? false}
     {:key :content, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; MultiSelectItems
;; -------------------------------------------------------------------------

(def MultiSelectItems
  "Items for a multi-select (array) property schema."
  [:or
   [:and
    [:map {:closed false} [:type [:= "string"]]]
    #'StringMultiSelectItems]
   [:and
    [:map {:closed false} [:type :string]]
    [:not [:map {:closed false} [:type [:= "string"]]]]]
   #'TitledMultiSelectItems])

(def ->MultiSelectItems
  "Create a `MultiSelectItems` value."
  (rt/make-value-constructor #'MultiSelectItems "MultiSelectItems"))

;; -------------------------------------------------------------------------
;; NewSessionRequest
;; -------------------------------------------------------------------------

(def NewSessionRequest
  "Request parameters for creating a new session. See protocol docs: [Creating a Session](https://agentclientprotocol.com/protocol/v1/session-setup#creating-a-session)"
  [:map
   {:closed false}
   [:cwd :string]
   [:additionalDirectories {:optional true} [:vector :string]]
   [:mcpServers [:vector #'McpServer]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->NewSessionRequest
  "Create a `NewSessionRequest` value."
  (rt/make-object-constructor
    #'NewSessionRequest
    "NewSessionRequest"
    [{:key :cwd, :required? true, :nullable? false}
     {:key :mcpServers, :required? true, :nullable? false}
     {:key :additionalDirectories, :required? false, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AgentNotification
;; -------------------------------------------------------------------------

(def AgentNotification
  "A JSON-RPC notification object."
  [:map
   {:closed false}
   [:method :string]
   [:params
    {:optional true}
    [:maybe
     [:or
      #'SessionNotification
      #'CompleteElicitationNotification
      #'ExtNotification]]]])

(def ->AgentNotification
  "Create a `AgentNotification` value."
  (rt/make-object-constructor
    #'AgentNotification
    "AgentNotification"
    [{:key :method, :required? true, :nullable? false}
     {:key :params, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; NoticeCapabilities
;; -------------------------------------------------------------------------

(def NoticeCapabilities
  "Client support for presenting live notices to the user."
  [:map {:closed false}])

(def ->NoticeCapabilities
  "Create a `NoticeCapabilities` value."
  (rt/make-object-constructor
    #'NoticeCapabilities
    "NoticeCapabilities"
    []
    false))

;; -------------------------------------------------------------------------
;; RequestPermissionRequest
;; -------------------------------------------------------------------------

(def RequestPermissionRequest
  "Request for user permission to execute a tool call. Sent when the agent needs authorization before performing a sensitive operation. See protocol docs: [Requesting Permission](https://agentclientprotocol.com/protocol/v1/tool-calls#requesting-permission)"
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:toolCall #'ToolCallUpdate]
   [:options [:vector #'PermissionOption]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->RequestPermissionRequest
  "Create a `RequestPermissionRequest` value."
  (rt/make-object-constructor
    #'RequestPermissionRequest
    "RequestPermissionRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :toolCall, :required? true, :nullable? false}
     {:key :options, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionUpdate
;; -------------------------------------------------------------------------

(def SessionUpdate
  "Different types of updates that can be sent during session processing. These updates provide real-time feedback about the agent's progress. See protocol docs: [Agent Reports Output](https://agentclientprotocol.com/protocol/v1/prompt-turn#3-agent-reports-output)"
  [:or
   [:and
    [:map {:closed false} [:sessionUpdate [:= "user_message_chunk"]]]
    #'ContentChunk]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "agent_message_chunk"]]]
    #'ContentChunk]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "agent_thought_chunk"]]]
    #'ContentChunk]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "tool_call"]]]
    #'ToolCall]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "tool_call_update"]]]
    #'ToolCallUpdate]
   [:and [:map {:closed false} [:sessionUpdate [:= "plan"]]] #'Plan]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "available_commands_update"]]]
    #'AvailableCommandsUpdate]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "current_mode_update"]]]
    #'CurrentModeUpdate]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "config_option_update"]]]
    #'ConfigOptionUpdate]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "session_info_update"]]]
    #'SessionInfoUpdate]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "usage_update"]]]
    #'UsageUpdate]
   [:and [:map {:closed false} [:sessionUpdate [:= "notice"]]] #'Notice]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "compaction_update"]]]
    #'CompactionUpdate]
   [:and
    [:map {:closed false} [:sessionUpdate [:= "compaction_summary_chunk"]]]
    #'CompactionSummaryChunk]])

(def ->SessionUpdate
  "Create a `SessionUpdate` value."
  (rt/make-value-constructor #'SessionUpdate "SessionUpdate"))

;; -------------------------------------------------------------------------
;; TitledMultiSelectItems
;; -------------------------------------------------------------------------

(def TitledMultiSelectItems
  "Items definition for titled multi-select enum properties."
  [:map
   {:closed false}
   [:anyOf [:vector #'EnumOption]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->TitledMultiSelectItems
  "Create a `TitledMultiSelectItems` value."
  (rt/make-object-constructor
    #'TitledMultiSelectItems
    "TitledMultiSelectItems"
    [{:key :anyOf, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; BlobResourceContents
;; -------------------------------------------------------------------------

(def BlobResourceContents
  "Binary resource contents."
  [:map
   {:closed false}
   [:blob :string]
   [:mimeType {:optional true} [:maybe :string]]
   [:uri :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->BlobResourceContents
  "Create a `BlobResourceContents` value."
  (rt/make-object-constructor
    #'BlobResourceContents
    "BlobResourceContents"
    [{:key :blob, :required? true, :nullable? false}
     {:key :uri, :required? true, :nullable? false}
     {:key :mimeType, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ResumeSessionResponse
;; -------------------------------------------------------------------------

(def ResumeSessionResponse
  "Response from resuming an existing session."
  [:map
   {:closed false}
   [:modes {:optional true} [:maybe #'SessionModeState]]
   [:configOptions
    {:optional true}
    [:maybe [:vector #'SessionConfigOption]]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ResumeSessionResponse
  "Create a `ResumeSessionResponse` value."
  (rt/make-object-constructor
    #'ResumeSessionResponse
    "ResumeSessionResponse"
    [{:key :modes, :required? false, :nullable? true}
     {:key :configOptions, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; Cost
;; -------------------------------------------------------------------------

(def Cost
  "Cost information for a session."
  [:map
   {:closed false}
   [:amount number?]
   [:currency :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->Cost
  "Create a `Cost` value."
  (rt/make-object-constructor
    #'Cost
    "Cost"
    [{:key :amount, :required? true, :nullable? false}
     {:key :currency, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionConfigSelectOptions
;; -------------------------------------------------------------------------

(def SessionConfigSelectOptions
  "Possible values for a session configuration option."
  [:or
   [:vector #'SessionConfigSelectOption]
   [:vector #'SessionConfigSelectGroup]])

(def ->SessionConfigSelectOptions
  "Create a `SessionConfigSelectOptions` value."
  (rt/make-value-constructor
    #'SessionConfigSelectOptions
    "SessionConfigSelectOptions"))

;; -------------------------------------------------------------------------
;; EmbeddedResourceResource
;; -------------------------------------------------------------------------

(def EmbeddedResourceResource
  "Resource content that can be embedded in a message."
  [:or #'TextResourceContents #'BlobResourceContents])

(def ->EmbeddedResourceResource
  "Create a `EmbeddedResourceResource` value."
  (rt/make-value-constructor
    #'EmbeddedResourceResource
    "EmbeddedResourceResource"))

;; -------------------------------------------------------------------------
;; SessionDeleteCapabilities
;; -------------------------------------------------------------------------

(def SessionDeleteCapabilities
  "Capabilities for the `session/delete` method. Supplying `{}` means the agent supports deleting sessions from `session/list`."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionDeleteCapabilities
  "Create a `SessionDeleteCapabilities` value."
  (rt/make-object-constructor
    #'SessionDeleteCapabilities
    "SessionDeleteCapabilities"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ImageContent
;; -------------------------------------------------------------------------

(def ImageContent
  "An image provided to or from an LLM."
  [:map
   {:closed false}
   [:annotations {:optional true} [:maybe #'Annotations]]
   [:data :string]
   [:mimeType :string]
   [:uri {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ImageContent
  "Create a `ImageContent` value."
  (rt/make-object-constructor
    #'ImageContent
    "ImageContent"
    [{:key :data, :required? true, :nullable? false}
     {:key :mimeType, :required? true, :nullable? false}
     {:key :annotations, :required? false, :nullable? true}
     {:key :uri, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationCapabilities
;; -------------------------------------------------------------------------

(def ElicitationCapabilities
  "Elicitation capabilities supported by the client."
  [:map
   {:closed false}
   [:form {:optional true} [:maybe #'ElicitationFormCapabilities]]
   [:url {:optional true} [:maybe #'ElicitationUrlCapabilities]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ElicitationCapabilities
  "Create a `ElicitationCapabilities` value."
  (rt/make-object-constructor
    #'ElicitationCapabilities
    "ElicitationCapabilities"
    [{:key :form, :required? false, :nullable? true}
     {:key :url, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; TerminalOutputRequest
;; -------------------------------------------------------------------------

(def TerminalOutputRequest
  "Request to get the current output and status of a terminal."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:terminalId #'TerminalId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->TerminalOutputRequest
  "Create a `TerminalOutputRequest` value."
  (rt/make-object-constructor
    #'TerminalOutputRequest
    "TerminalOutputRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :terminalId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionListCapabilities
;; -------------------------------------------------------------------------

(def SessionListCapabilities
  "Capabilities for the `session/list` method. Supplying `{}` means the agent supports listing sessions."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionListCapabilities
  "Create a `SessionListCapabilities` value."
  (rt/make-object-constructor
    #'SessionListCapabilities
    "SessionListCapabilities"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; Error
;; -------------------------------------------------------------------------

(def Error
  "JSON-RPC error object. Represents an error that occurred during method execution, following the JSON-RPC 2.0 error object specification with optional additional data. See protocol docs: [JSON-RPC Error Object](https://www.jsonrpc.org/specification#error_object)"
  [:map
   {:closed false}
   [:code #'ErrorCode]
   [:message :string]
   [:data {:optional true} :any]])

(def ->Error
  "Create a `Error` value."
  (rt/make-object-constructor
    #'Error
    "Error"
    [{:key :code, :required? true, :nullable? false}
     {:key :message, :required? true, :nullable? false}
     {:key :data, :required? false, :nullable? false}]
    false))

;; -------------------------------------------------------------------------
;; DeleteSessionRequest
;; -------------------------------------------------------------------------

(def DeleteSessionRequest
  "Request parameters for deleting an existing session from `session/list`. Only available if the Agent supports the `sessionCapabilities.delete` capability."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->DeleteSessionRequest
  "Create a `DeleteSessionRequest` value."
  (rt/make-object-constructor
    #'DeleteSessionRequest
    "DeleteSessionRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationSessionScope
;; -------------------------------------------------------------------------

(def ElicitationSessionScope
  "Session-scoped elicitation, optionally tied to a specific tool call. When `toolCallId` is set, the elicitation is tied to a specific tool call. This is useful when an agent receives an elicitation from an MCP server during a tool call and needs to redirect it to the user."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:toolCallId {:optional true} [:maybe #'ToolCallId]]])

(def ->ElicitationSessionScope
  "Create a `ElicitationSessionScope` value."
  (rt/make-object-constructor
    #'ElicitationSessionScope
    "ElicitationSessionScope"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :toolCallId, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ReleaseTerminalResponse
;; -------------------------------------------------------------------------

(def ReleaseTerminalResponse
  "Response to terminal/release method"
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ReleaseTerminalResponse
  "Create a `ReleaseTerminalResponse` value."
  (rt/make-object-constructor
    #'ReleaseTerminalResponse
    "ReleaseTerminalResponse"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; RequestPermissionResponse
;; -------------------------------------------------------------------------

(def RequestPermissionResponse
  "Response to a permission request."
  [:map
   {:closed false}
   [:outcome #'RequestPermissionOutcome]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->RequestPermissionResponse
  "Create a `RequestPermissionResponse` value."
  (rt/make-object-constructor
    #'RequestPermissionResponse
    "RequestPermissionResponse"
    [{:key :outcome, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; PromptCapabilities
;; -------------------------------------------------------------------------

(def PromptCapabilities
  "Prompt capabilities supported by the agent in `session/prompt` requests. Baseline agent functionality requires support for `text` and `resource_link` content blocks in prompt requests. Other variants must be explicitly opted in to. Capabilities for different types of content in prompt requests. Indicates which content types beyond the baseline (text and resource links) the agent can process. See protocol docs: [Prompt Capabilities](https://agentclientprotocol.com/protocol/v1/initialization#prompt-capabilities)"
  [:map
   {:closed false}
   [:image {:optional true} :boolean]
   [:audio {:optional true} :boolean]
   [:embeddedContext {:optional true} :boolean]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->PromptCapabilities
  "Create a `PromptCapabilities` value."
  (rt/make-object-constructor
    #'PromptCapabilities
    "PromptCapabilities"
    [{:key :image, :required? false, :nullable? false}
     {:key :audio, :required? false, :nullable? false}
     {:key :embeddedContext, :required? false, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionConfigBoolean
;; -------------------------------------------------------------------------

(def SessionConfigBoolean
  "A boolean on/off toggle session configuration option payload."
  [:map {:closed false} [:currentValue :boolean]])

(def ->SessionConfigBoolean
  "Create a `SessionConfigBoolean` value."
  (rt/make-object-constructor
    #'SessionConfigBoolean
    "SessionConfigBoolean"
    [{:key :currentValue, :required? true, :nullable? false}]
    false))

;; -------------------------------------------------------------------------
;; CompactionUpdate
;; -------------------------------------------------------------------------

(def CompactionUpdate
  "A context compaction upsert. The first notification fixes the compaction's timeline position. Later updates with the same ID patch that entity in place. Agents MUST only send this update when the Client advertised the `session.compaction` Client capability. `summary`, `error`, and `_meta` have patch semantics: omission leaves the stored value unchanged, `null` clears it, and a concrete value replaces it. `summary: []` also clears the summary."
  [:map
   {:closed false}
   [:compactionId #'CompactionId]
   [:status #'CompactionStatus]
   [:summary {:optional true} [:maybe [:vector #'ContentBlock]]]
   [:error {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CompactionUpdate
  "Create a `CompactionUpdate` value."
  (rt/make-object-constructor
    #'CompactionUpdate
    "CompactionUpdate"
    [{:key :compactionId, :required? true, :nullable? false}
     {:key :status, :required? true, :nullable? false}
     {:key :summary, :required? false, :nullable? true}
     {:key :error, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; CloseSessionResponse
;; -------------------------------------------------------------------------

(def CloseSessionResponse
  "Response from closing a session."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->CloseSessionResponse
  "Create a `CloseSessionResponse` value."
  (rt/make-object-constructor
    #'CloseSessionResponse
    "CloseSessionResponse"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ToolCallId
;; -------------------------------------------------------------------------

(def ToolCallId
  "Unique identifier for a tool call within a session."
  :string)

(def ->ToolCallId
  "Create a `ToolCallId` value."
  (rt/make-value-constructor #'ToolCallId "ToolCallId"))

;; -------------------------------------------------------------------------
;; SessionModeId
;; -------------------------------------------------------------------------

(def SessionModeId
  "Unique identifier for a Session Mode."
  :string)

(def ->SessionModeId
  "Create a `SessionModeId` value."
  (rt/make-value-constructor #'SessionModeId "SessionModeId"))

;; -------------------------------------------------------------------------
;; PlanEntryPriority
;; -------------------------------------------------------------------------

(def PlanEntryPriority
  "Priority levels for plan entries. Used to indicate the relative importance or urgency of different tasks in the execution plan. See protocol docs: [Plan Entries](https://agentclientprotocol.com/protocol/v1/agent-plan#plan-entries)"
  [:enum "high" "medium" "low"])

(def ->PlanEntryPriority
  "Create a `PlanEntryPriority` value."
  (rt/make-value-constructor #'PlanEntryPriority "PlanEntryPriority"))

;; -------------------------------------------------------------------------
;; CompactionStatus
;; -------------------------------------------------------------------------

(def CompactionStatus
  "Lifecycle state of a context compaction."
  [:or
   [:= "in_progress"]
   [:= "completed"]
   [:= "failed"]
   [:= "cancelled"]
   :string])

(def ->CompactionStatus
  "Create a `CompactionStatus` value."
  (rt/make-value-constructor #'CompactionStatus "CompactionStatus"))

;; -------------------------------------------------------------------------
;; DeleteSessionResponse
;; -------------------------------------------------------------------------

(def DeleteSessionResponse
  "Response from deleting a session."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->DeleteSessionResponse
  "Create a `DeleteSessionResponse` value."
  (rt/make-object-constructor
    #'DeleteSessionResponse
    "DeleteSessionResponse"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionCloseCapabilities
;; -------------------------------------------------------------------------

(def SessionCloseCapabilities
  "Capabilities for the `session/close` method. Supplying `{}` means the agent supports closing sessions."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionCloseCapabilities
  "Create a `SessionCloseCapabilities` value."
  (rt/make-object-constructor
    #'SessionCloseCapabilities
    "SessionCloseCapabilities"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ReadTextFileRequest
;; -------------------------------------------------------------------------

(def ReadTextFileRequest
  "Request to read content from a text file. Only available if the client supports the `fs.readTextFile` capability."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:path :string]
   [:line {:optional true} [:maybe [:int {:min 0}]]]
   [:limit {:optional true} [:maybe [:int {:min 0}]]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ReadTextFileRequest
  "Create a `ReadTextFileRequest` value."
  (rt/make-object-constructor
    #'ReadTextFileRequest
    "ReadTextFileRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :path, :required? true, :nullable? false}
     {:key :line, :required? false, :nullable? true}
     {:key :limit, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ClientResponse
;; -------------------------------------------------------------------------

(def ClientResponse
  "A JSON-RPC response object."
  [:or
   [:map
    {:closed false}
    [:id #'RequestId]
    [:result
     [:or
      #'WriteTextFileResponse
      #'ReadTextFileResponse
      #'RequestPermissionResponse
      #'CreateTerminalResponse
      #'TerminalOutputResponse
      #'ReleaseTerminalResponse
      #'WaitForTerminalExitResponse
      #'KillTerminalResponse
      #'CreateElicitationResponse
      #'ExtResponse]]]
   [:map {:closed false} [:id #'RequestId] [:error #'Error]]])

(def ->ClientResponse
  "Create a `ClientResponse` value."
  (rt/make-value-constructor #'ClientResponse "ClientResponse"))

;; -------------------------------------------------------------------------
;; SessionInfo
;; -------------------------------------------------------------------------

(def SessionInfo
  "Information about a session returned by session/list"
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:cwd :string]
   [:additionalDirectories {:optional true} [:vector :string]]
   [:title {:optional true} [:maybe :string]]
   [:updatedAt {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionInfo
  "Create a `SessionInfo` value."
  (rt/make-object-constructor
    #'SessionInfo
    "SessionInfo"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :cwd, :required? true, :nullable? false}
     {:key :additionalDirectories, :required? false, :nullable? false}
     {:key :title, :required? false, :nullable? true}
     {:key :updatedAt, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ResumeSessionRequest
;; -------------------------------------------------------------------------

(def ResumeSessionRequest
  "Request parameters for resuming an existing session. Resumes an existing session without returning previous messages (unlike `session/load`). This is useful for agents that can resume sessions but don't implement full session loading. Only available if the Agent supports the `sessionCapabilities.resume` capability."
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:cwd :string]
   [:additionalDirectories {:optional true} [:vector :string]]
   [:mcpServers {:optional true} [:vector #'McpServer]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ResumeSessionRequest
  "Create a `ResumeSessionRequest` value."
  (rt/make-object-constructor
    #'ResumeSessionRequest
    "ResumeSessionRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :cwd, :required? true, :nullable? false}
     {:key :additionalDirectories, :required? false, :nullable? false}
     {:key :mcpServers, :required? false, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; PlanEntry
;; -------------------------------------------------------------------------

(def PlanEntry
  "A single entry in the execution plan. Represents a task or goal that the assistant intends to accomplish as part of fulfilling the user's request. See protocol docs: [Plan Entries](https://agentclientprotocol.com/protocol/v1/agent-plan#plan-entries)"
  [:map
   {:closed false}
   [:content :string]
   [:priority #'PlanEntryPriority]
   [:status #'PlanEntryStatus]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->PlanEntry
  "Create a `PlanEntry` value."
  (rt/make-object-constructor
    #'PlanEntry
    "PlanEntry"
    [{:key :content, :required? true, :nullable? false}
     {:key :priority, :required? true, :nullable? false}
     {:key :status, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; TextContent
;; -------------------------------------------------------------------------

(def TextContent
  "Text provided to or from an LLM."
  [:map
   {:closed false}
   [:annotations {:optional true} [:maybe #'Annotations]]
   [:text :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->TextContent
  "Create a `TextContent` value."
  (rt/make-object-constructor
    #'TextContent
    "TextContent"
    [{:key :text, :required? true, :nullable? false}
     {:key :annotations, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; SessionCapabilities
;; -------------------------------------------------------------------------

(def SessionCapabilities
  "Session capabilities supported by the agent. As a baseline, all Agents **MUST** support `session/new`, `session/prompt`, `session/cancel`, and `session/update`. Optionally, they **MAY** support other session methods and notifications by specifying additional capabilities. Note: `session/load` is still handled by the top-level `loadSession` capability. This will be unified in future versions of the protocol. See protocol docs: [Session Capabilities](https://agentclientprotocol.com/protocol/v1/initialization#session-capabilities)"
  [:map
   {:closed false}
   [:list {:optional true} [:maybe #'SessionListCapabilities]]
   [:delete {:optional true} [:maybe #'SessionDeleteCapabilities]]
   [:additionalDirectories
    {:optional true}
    [:maybe #'SessionAdditionalDirectoriesCapabilities]]
   [:resume {:optional true} [:maybe #'SessionResumeCapabilities]]
   [:close {:optional true} [:maybe #'SessionCloseCapabilities]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionCapabilities
  "Create a `SessionCapabilities` value."
  (rt/make-object-constructor
    #'SessionCapabilities
    "SessionCapabilities"
    [{:key :list, :required? false, :nullable? true}
     {:key :delete, :required? false, :nullable? true}
     {:key :additionalDirectories, :required? false, :nullable? true}
     {:key :resume, :required? false, :nullable? true}
     {:key :close, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; PromptRequest
;; -------------------------------------------------------------------------

(def PromptRequest
  "Request parameters for sending a user prompt to the agent. Contains the user's message and any additional context. See protocol docs: [User Message](https://agentclientprotocol.com/protocol/v1/prompt-turn#1-user-message)"
  [:map
   {:closed false}
   [:sessionId #'SessionId]
   [:prompt [:vector #'ContentBlock]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->PromptRequest
  "Create a `PromptRequest` value."
  (rt/make-object-constructor
    #'PromptRequest
    "PromptRequest"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :prompt, :required? true, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AgentAuthCapabilities
;; -------------------------------------------------------------------------

(def AgentAuthCapabilities
  "Authentication-related capabilities supported by the agent."
  [:map
   {:closed false}
   [:logout {:optional true} [:maybe #'LogoutCapabilities]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AgentAuthCapabilities
  "Create a `AgentAuthCapabilities` value."
  (rt/make-object-constructor
    #'AgentAuthCapabilities
    "AgentAuthCapabilities"
    [{:key :logout, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; AuthMethodTerminal
;; -------------------------------------------------------------------------

(def AuthMethodTerminal
  "Terminal-based authentication method. The client runs the configured agent program as a separate interactive process for the user to authenticate via a TUI. Agents MUST advertise this method only when the client enabled its terminal authentication capability. A zero exit status signals success; any other termination signals failure. The client MUST NOT pass this method to `authenticate`."
  [:map
   {:closed false}
   [:id #'AuthMethodId]
   [:name :string]
   [:description {:optional true} [:maybe :string]]
   [:args {:optional true} [:vector :string]]
   [:env {:optional true} [:map-of :string :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AuthMethodTerminal
  "Create a `AuthMethodTerminal` value."
  (rt/make-object-constructor
    #'AuthMethodTerminal
    "AuthMethodTerminal"
    [{:key :id, :required? true, :nullable? false}
     {:key :name, :required? true, :nullable? false}
     {:key :description, :required? false, :nullable? true}
     {:key :args, :required? false, :nullable? false}
     {:key :env, :required? false, :nullable? false}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; CreateElicitationResponse
;; -------------------------------------------------------------------------

(def CreateElicitationResponse
  "Response from the client to an elicitation request."
  [:and
   [:map
    {:closed false}
    [:_meta {:optional true} [:maybe [:map {:closed false}]]]]
   [:or
    [:and
     [:map {:closed false} [:action [:= "accept"]]]
     #'ElicitationAcceptAction]
    [:map {:closed false} [:action [:= "decline"]]]
    [:map {:closed false} [:action [:= "cancel"]]]
    [:and
     [:map {:closed false} [:action :string]]
     [:not
      [:or
       [:map {:closed false} [:action [:= "accept"]]]
       [:map {:closed false} [:action [:= "decline"]]]
       [:map {:closed false} [:action [:= "cancel"]]]]]]]])

(def ->CreateElicitationResponse
  "Create a `CreateElicitationResponse` value."
  (rt/make-object-constructor
    #'CreateElicitationResponse
    "CreateElicitationResponse"
    [{:key :_meta, :required? false, :nullable? true}]
    true))

;; -------------------------------------------------------------------------
;; AvailableCommand
;; -------------------------------------------------------------------------

(def AvailableCommand
  "Information about a command."
  [:map
   {:closed false}
   [:name :string]
   [:description :string]
   [:input {:optional true} [:maybe #'AvailableCommandInput]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->AvailableCommand
  "Create a `AvailableCommand` value."
  (rt/make-object-constructor
    #'AvailableCommand
    "AvailableCommand"
    [{:key :name, :required? true, :nullable? false}
     {:key :description, :required? true, :nullable? false}
     {:key :input, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ElicitationContentValue
;; -------------------------------------------------------------------------

(def ElicitationContentValue
  "Allowed wire representations for `ElicitationContentValue`."
  [:or :string :int number? :boolean [:vector :string]])

(def ->ElicitationContentValue
  "Create a `ElicitationContentValue` value."
  (rt/make-value-constructor
    #'ElicitationContentValue
    "ElicitationContentValue"))

;; -------------------------------------------------------------------------
;; LogoutCapabilities
;; -------------------------------------------------------------------------

(def LogoutCapabilities
  "Logout capabilities supported by the agent. Supplying `{}` means the agent supports the logout method."
  [:map
   {:closed false}
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->LogoutCapabilities
  "Create a `LogoutCapabilities` value."
  (rt/make-object-constructor
    #'LogoutCapabilities
    "LogoutCapabilities"
    [{:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; TerminalId
;; -------------------------------------------------------------------------

(def TerminalId
  "Typed identifier used for terminal values on the wire."
  :string)

(def ->TerminalId
  "Create a `TerminalId` value."
  (rt/make-value-constructor #'TerminalId "TerminalId"))

;; -------------------------------------------------------------------------
;; SessionInfoUpdate
;; -------------------------------------------------------------------------

(def SessionInfoUpdate
  "Update to session metadata. All fields are optional to support partial updates. Agents send this notification to update session information like title or custom metadata. This allows clients to display dynamic session names and track session state changes."
  [:map
   {:closed false}
   [:title {:optional true} [:maybe :string]]
   [:updatedAt {:optional true} [:maybe :string]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->SessionInfoUpdate
  "Create a `SessionInfoUpdate` value."
  (rt/make-object-constructor
    #'SessionInfoUpdate
    "SessionInfoUpdate"
    [{:key :title, :required? false, :nullable? true}
     {:key :updatedAt, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; ExtNotification
;; -------------------------------------------------------------------------

(def ExtNotification
  "Allows either side to send an arbitrary notification that is not part of the ACP spec. Extension notifications provide a way to send one-way messages for custom functionality while maintaining protocol compatibility. See protocol docs: [Extensibility](https://agentclientprotocol.com/protocol/v1/extensibility)"
  :any)

(def ->ExtNotification
  "Create a `ExtNotification` value."
  (rt/make-value-constructor #'ExtNotification "ExtNotification"))

;; -------------------------------------------------------------------------
;; ClientCapabilities
;; -------------------------------------------------------------------------

(def ClientCapabilities
  "Capabilities supported by the client. Advertised during initialization to inform the agent about available features and methods. See protocol docs: [Client Capabilities](https://agentclientprotocol.com/protocol/v1/initialization#client-capabilities)"
  [:map
   {:closed false}
   [:fs {:optional true} #'FileSystemCapabilities]
   [:terminal {:optional true} :boolean]
   [:session {:optional true} [:maybe #'ClientSessionCapabilities]]
   [:auth {:optional true} #'AuthCapabilities]
   [:elicitation {:optional true} [:maybe #'ElicitationCapabilities]]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(def ->ClientCapabilities
  "Create a `ClientCapabilities` value."
  (rt/make-object-constructor
    #'ClientCapabilities
    "ClientCapabilities"
    [{:key :fs, :required? false, :nullable? false}
     {:key :terminal, :required? false, :nullable? false}
     {:key :session, :required? false, :nullable? true}
     {:key :auth, :required? false, :nullable? false}
     {:key :elicitation, :required? false, :nullable? true}
     {:key :_meta, :required? false, :nullable? true}]
    false))

;; -------------------------------------------------------------------------
;; RequestPermissionOutcome
;; -------------------------------------------------------------------------

(def RequestPermissionOutcome
  "The outcome of a permission request."
  [:or
   [:map {:closed false} [:outcome [:= "cancelled"]]]
   [:and
    [:map {:closed false} [:outcome [:= "selected"]]]
    #'SelectedPermissionOutcome]])

(def ->RequestPermissionOutcome
  "Create a `RequestPermissionOutcome` value."
  (rt/make-value-constructor
    #'RequestPermissionOutcome
    "RequestPermissionOutcome"))

;; -------------------------------------------------------------------------
;; ClientRequest
;; -------------------------------------------------------------------------

(def ClientRequest
  "A JSON-RPC request object."
  [:map
   {:closed false}
   [:id #'RequestId]
   [:method :string]
   [:params
    {:optional true}
    [:maybe
     [:or
      #'InitializeRequest
      #'AuthenticateRequest
      #'LogoutRequest
      #'NewSessionRequest
      #'LoadSessionRequest
      #'ListSessionsRequest
      #'DeleteSessionRequest
      #'ResumeSessionRequest
      #'CloseSessionRequest
      #'SetSessionModeRequest
      #'SetSessionConfigOptionRequest
      #'PromptRequest
      #'ExtRequest]]]])

(def ->ClientRequest
  "Create a `ClientRequest` value."
  (rt/make-object-constructor
    #'ClientRequest
    "ClientRequest"
    [{:key :id, :required? true, :nullable? false}
     {:key :method, :required? true, :nullable? false}
     {:key :params, :required? false, :nullable? true}]
    false))
