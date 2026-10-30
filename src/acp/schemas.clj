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
;;
;; The protocol types that have been split into their own namespaces
;; (`acp.schema.content`, `acp.schema.common`, `acp.schema.terminal`,
;; `acp.schema.tool`, `acp.schema.mcp`, `acp.schema.session`) are re-exported
;; here as plain `def` aliases, so `acp.schemas` stays the single import for
;; callers.  The aliases and the `declare` below are maintained by hand.
;; -------------------------------------------------------------------------

(ns acp.schemas
  "Malli schemas for the Agent Client Protocol.

  Generated from acp/schema.json by `acp.schema-tools`. Types that were
  moved into `acp.schema.*` namespaces are re-exported here."
  (:require [acp.schema-runtime :as rt]
            [acp.schema.content :as content]
            [acp.schema.terminal :as terminal]
            [acp.schema.tool :as tool]
            [acp.schema.mcp :as mcp]
            [acp.schema.session :as session]
            [malli.core :as m]
            [malli.error :as me]))

;; ---------------------------------------------------------------------------
;; Validation
;; ---------------------------------------------------------------------------

(defn validate!
"Validate `value` against `schema`, returning `value` when valid or throwing
an `ex-info` with a human-readable malli error explanation otherwise."
[schema value what]
(if-let [errors (and schema (m/explain schema value))]
  (let [explained (me/humanize errors)]
    (throw (ex-info (str "Invalid " what ": " (pr-str explained))
                    {:schema schema :value value :errors errors})))
  value))

;; The protocol defines a type named `Error`, so drop java.lang's
;; automatic class mapping before it becomes a var.
(when (class? (get (ns-map *ns*) 'Error))
  (ns-unmap *ns* 'Error))

(def Role content/Role)
(def ->Role content/->Role)

(def Annotations content/Annotations)
(def ->Annotations content/->Annotations)

(def TextContent content/TextContent)
(def ->TextContent content/->TextContent)

(def ImageContent content/ImageContent)
(def ->ImageContent content/->ImageContent)

(def AudioContent content/AudioContent)
(def ->AudioContent content/->AudioContent)

(def ResourceLink content/ResourceLink)
(def ->ResourceLink content/->ResourceLink)

(def TextResourceContents content/TextResourceContents)
(def ->TextResourceContents content/->TextResourceContents)

(def BlobResourceContents content/BlobResourceContents)
(def ->BlobResourceContents content/->BlobResourceContents)

(def EmbeddedResourceResource content/EmbeddedResourceResource)
(def ->EmbeddedResourceResource content/->EmbeddedResourceResource)

(def EmbeddedResource content/EmbeddedResource)
(def ->EmbeddedResource content/->EmbeddedResource)

(def ContentBlock content/ContentBlock)
(def ->ContentBlock content/->ContentBlock)

(def Content content/Content)
(def ->Content content/->Content)

(def Diff content/Diff)
(def ->Diff content/->Diff)

(def TerminalExitStatus terminal/TerminalExitStatus)
(def ->TerminalExitStatus terminal/->TerminalExitStatus)

(def TerminalId terminal/TerminalId)
(def ->TerminalId terminal/->TerminalId)

(def TerminalOutputResponse terminal/TerminalOutputResponse)
(def ->TerminalOutputResponse terminal/->TerminalOutputResponse)

(def Terminal terminal/Terminal)
(def ->Terminal terminal/->Terminal)

(def CreateTerminalRequest tool/CreateTerminalRequest)
(def ->CreateTerminalRequest tool/->CreateTerminalRequest)

(def CreateTerminalResponse tool/CreateTerminalResponse)
(def ->CreateTerminalResponse tool/->CreateTerminalResponse)

(def TerminalOutputRequest tool/TerminalOutputRequest)
(def ->TerminalOutputRequest tool/->TerminalOutputRequest)

(def KillTerminalRequest tool/KillTerminalRequest)
(def ->KillTerminalRequest tool/->KillTerminalRequest)

(def KillTerminalResponse tool/KillTerminalResponse)
(def ->KillTerminalResponse tool/->KillTerminalResponse)

(def WaitForTerminalExitRequest tool/WaitForTerminalExitRequest)
(def ->WaitForTerminalExitRequest tool/->WaitForTerminalExitRequest)

(def WaitForTerminalExitResponse tool/WaitForTerminalExitResponse)
(def ->WaitForTerminalExitResponse tool/->WaitForTerminalExitResponse)

(def ReleaseTerminalRequest tool/ReleaseTerminalRequest)
(def ->ReleaseTerminalRequest tool/->ReleaseTerminalRequest)

(def ReleaseTerminalResponse tool/ReleaseTerminalResponse)
(def ->ReleaseTerminalResponse tool/->ReleaseTerminalResponse)

(def ToolKind tool/ToolKind)
(def ->ToolKind tool/->ToolKind)

(def ToolCallContent tool/ToolCallContent)
(def ->ToolCallContent tool/->ToolCallContent)

(def EnvVariable mcp/EnvVariable)
(def ->EnvVariable mcp/->EnvVariable)

(def HttpHeader mcp/HttpHeader)
(def ->HttpHeader mcp/->HttpHeader)

(def McpServer mcp/McpServer)
(def ->McpServer mcp/->McpServer)

(def McpServerHttp mcp/McpServerHttp)
(def ->McpServerHttp mcp/->McpServerHttp)

(def McpServerSse mcp/McpServerSse)
(def ->McpServerSse mcp/->McpServerSse)

(def McpServerStdio mcp/McpServerStdio)
(def ->McpServerStdio mcp/->McpServerStdio)


(def ToolCall tool/ToolCall)
(def ->ToolCall tool/->ToolCall)

(def ToolCallId tool/ToolCallId)
(def ->ToolCallId tool/->ToolCallId)

(def ToolCallLocation tool/ToolCallLocation)
(def ->ToolCallLocation tool/->ToolCallLocation)

(def ToolCallStatus tool/ToolCallStatus)
(def ->ToolCallStatus tool/->ToolCallStatus)

(def ToolCallUpdate tool/ToolCallUpdate)
(def ->ToolCallUpdate tool/->ToolCallUpdate)


(def AvailableCommand session/AvailableCommand)
(def ->AvailableCommand session/->AvailableCommand)

(def AvailableCommandInput session/AvailableCommandInput)
(def ->AvailableCommandInput session/->AvailableCommandInput)

(def AvailableCommandsUpdate session/AvailableCommandsUpdate)
(def ->AvailableCommandsUpdate session/->AvailableCommandsUpdate)

(def BooleanConfigOptionCapabilities session/BooleanConfigOptionCapabilities)
(def ->BooleanConfigOptionCapabilities session/->BooleanConfigOptionCapabilities)

(def CancelNotification session/CancelNotification)
(def ->CancelNotification session/->CancelNotification)

(def ClientSessionCapabilities session/ClientSessionCapabilities)
(def ->ClientSessionCapabilities session/->ClientSessionCapabilities)

(def CloseSessionRequest session/CloseSessionRequest)
(def ->CloseSessionRequest session/->CloseSessionRequest)

(def CloseSessionResponse session/CloseSessionResponse)
(def ->CloseSessionResponse session/->CloseSessionResponse)

(def CompactionCapabilities session/CompactionCapabilities)
(def ->CompactionCapabilities session/->CompactionCapabilities)

(def CompactionId session/CompactionId)
(def ->CompactionId session/->CompactionId)

(def CompactionStatus session/CompactionStatus)
(def ->CompactionStatus session/->CompactionStatus)

(def CompactionSummaryChunk session/CompactionSummaryChunk)
(def ->CompactionSummaryChunk session/->CompactionSummaryChunk)

(def CompactionUpdate session/CompactionUpdate)
(def ->CompactionUpdate session/->CompactionUpdate)

(def ConfigOptionUpdate session/ConfigOptionUpdate)
(def ->ConfigOptionUpdate session/->ConfigOptionUpdate)

(def ContentChunk session/ContentChunk)
(def ->ContentChunk session/->ContentChunk)

(def Cost session/Cost)
(def ->Cost session/->Cost)

(def CurrentModeUpdate session/CurrentModeUpdate)
(def ->CurrentModeUpdate session/->CurrentModeUpdate)

(def DeleteSessionRequest session/DeleteSessionRequest)
(def ->DeleteSessionRequest session/->DeleteSessionRequest)

(def DeleteSessionResponse session/DeleteSessionResponse)
(def ->DeleteSessionResponse session/->DeleteSessionResponse)

(def ListSessionsRequest session/ListSessionsRequest)
(def ->ListSessionsRequest session/->ListSessionsRequest)

(def ListSessionsResponse session/ListSessionsResponse)
(def ->ListSessionsResponse session/->ListSessionsResponse)

(def LoadSessionRequest session/LoadSessionRequest)
(def ->LoadSessionRequest session/->LoadSessionRequest)

(def LoadSessionResponse session/LoadSessionResponse)
(def ->LoadSessionResponse session/->LoadSessionResponse)

(def MessageId session/MessageId)
(def ->MessageId session/->MessageId)

(def NewSessionRequest session/NewSessionRequest)
(def ->NewSessionRequest session/->NewSessionRequest)

(def NewSessionResponse session/NewSessionResponse)
(def ->NewSessionResponse session/->NewSessionResponse)

(def Notice session/Notice)
(def ->Notice session/->Notice)

(def NoticeCapabilities session/NoticeCapabilities)
(def ->NoticeCapabilities session/->NoticeCapabilities)

(def NoticeSeverity session/NoticeSeverity)
(def ->NoticeSeverity session/->NoticeSeverity)

(def PermissionOption session/PermissionOption)
(def ->PermissionOption session/->PermissionOption)

(def PermissionOptionId session/PermissionOptionId)
(def ->PermissionOptionId session/->PermissionOptionId)

(def PermissionOptionKind session/PermissionOptionKind)
(def ->PermissionOptionKind session/->PermissionOptionKind)

(def Plan session/Plan)
(def ->Plan session/->Plan)

(def PlanEntry session/PlanEntry)
(def ->PlanEntry session/->PlanEntry)

(def PlanEntryPriority session/PlanEntryPriority)
(def ->PlanEntryPriority session/->PlanEntryPriority)

(def PlanEntryStatus session/PlanEntryStatus)
(def ->PlanEntryStatus session/->PlanEntryStatus)

(def PromptRequest session/PromptRequest)
(def ->PromptRequest session/->PromptRequest)

(def PromptResponse session/PromptResponse)
(def ->PromptResponse session/->PromptResponse)

(def RequestPermissionOutcome session/RequestPermissionOutcome)
(def ->RequestPermissionOutcome session/->RequestPermissionOutcome)

(def RequestPermissionRequest session/RequestPermissionRequest)
(def ->RequestPermissionRequest session/->RequestPermissionRequest)

(def RequestPermissionResponse session/RequestPermissionResponse)
(def ->RequestPermissionResponse session/->RequestPermissionResponse)

(def ResumeSessionRequest session/ResumeSessionRequest)
(def ->ResumeSessionRequest session/->ResumeSessionRequest)

(def ResumeSessionResponse session/ResumeSessionResponse)
(def ->ResumeSessionResponse session/->ResumeSessionResponse)

(def SelectedPermissionOutcome session/SelectedPermissionOutcome)
(def ->SelectedPermissionOutcome session/->SelectedPermissionOutcome)

(def SessionAdditionalDirectoriesCapabilities session/SessionAdditionalDirectoriesCapabilities)
(def ->SessionAdditionalDirectoriesCapabilities session/->SessionAdditionalDirectoriesCapabilities)

(def SessionCapabilities session/SessionCapabilities)
(def ->SessionCapabilities session/->SessionCapabilities)

(def SessionCloseCapabilities session/SessionCloseCapabilities)
(def ->SessionCloseCapabilities session/->SessionCloseCapabilities)

(def SessionConfigBoolean session/SessionConfigBoolean)
(def ->SessionConfigBoolean session/->SessionConfigBoolean)

(def SessionConfigGroupId session/SessionConfigGroupId)
(def ->SessionConfigGroupId session/->SessionConfigGroupId)

(def SessionConfigId session/SessionConfigId)
(def ->SessionConfigId session/->SessionConfigId)

(def SessionConfigOption session/SessionConfigOption)
(def ->SessionConfigOption session/->SessionConfigOption)

(def SessionConfigOptionCategory session/SessionConfigOptionCategory)
(def ->SessionConfigOptionCategory session/->SessionConfigOptionCategory)

(def SessionConfigOptionsCapabilities session/SessionConfigOptionsCapabilities)
(def ->SessionConfigOptionsCapabilities session/->SessionConfigOptionsCapabilities)

(def SessionConfigSelect session/SessionConfigSelect)
(def ->SessionConfigSelect session/->SessionConfigSelect)

(def SessionConfigSelectGroup session/SessionConfigSelectGroup)
(def ->SessionConfigSelectGroup session/->SessionConfigSelectGroup)

(def SessionConfigSelectOption session/SessionConfigSelectOption)
(def ->SessionConfigSelectOption session/->SessionConfigSelectOption)

(def SessionConfigSelectOptions session/SessionConfigSelectOptions)
(def ->SessionConfigSelectOptions session/->SessionConfigSelectOptions)

(def SessionConfigValueId session/SessionConfigValueId)
(def ->SessionConfigValueId session/->SessionConfigValueId)

(def SessionDeleteCapabilities session/SessionDeleteCapabilities)
(def ->SessionDeleteCapabilities session/->SessionDeleteCapabilities)

(def SessionId session/SessionId)
(def ->SessionId session/->SessionId)

(def SessionInfo session/SessionInfo)
(def ->SessionInfo session/->SessionInfo)

(def SessionInfoUpdate session/SessionInfoUpdate)
(def ->SessionInfoUpdate session/->SessionInfoUpdate)

(def SessionListCapabilities session/SessionListCapabilities)
(def ->SessionListCapabilities session/->SessionListCapabilities)

(def SessionMode session/SessionMode)
(def ->SessionMode session/->SessionMode)

(def SessionModeId session/SessionModeId)
(def ->SessionModeId session/->SessionModeId)

(def SessionModeState session/SessionModeState)
(def ->SessionModeState session/->SessionModeState)

(def SessionNotification session/SessionNotification)
(def ->SessionNotification session/->SessionNotification)

(def SessionResumeCapabilities session/SessionResumeCapabilities)
(def ->SessionResumeCapabilities session/->SessionResumeCapabilities)

(def SessionUpdate session/SessionUpdate)
(def ->SessionUpdate session/->SessionUpdate)

(def SetSessionConfigOptionRequest session/SetSessionConfigOptionRequest)
(def ->SetSessionConfigOptionRequest session/->SetSessionConfigOptionRequest)

(def SetSessionConfigOptionResponse session/SetSessionConfigOptionResponse)
(def ->SetSessionConfigOptionResponse session/->SetSessionConfigOptionResponse)

(def SetSessionModeRequest session/SetSessionModeRequest)
(def ->SetSessionModeRequest session/->SetSessionModeRequest)

(def SetSessionModeResponse session/SetSessionModeResponse)
(def ->SetSessionModeResponse session/->SetSessionModeResponse)

(def StopReason session/StopReason)
(def ->StopReason session/->StopReason)

(def UnstructuredCommandInput session/UnstructuredCommandInput)
(def ->UnstructuredCommandInput session/->UnstructuredCommandInput)

(def UsageUpdate session/UsageUpdate)
(def ->UsageUpdate session/->UsageUpdate)

;; Schemas refer to one another, so declare every name up front.
(declare
 AgentResponse
 ElicitationFormCapabilities
 AuthMethod
 InitializeRequest
 RequestId
 ReadTextFileResponse
 WriteTextFileResponse
 CreateElicitationRequest
 ElicitationSchemaType
 AuthCapabilities
 WriteTextFileRequest
 ExtRequest
 AuthenticateRequest
 LogoutRequest
 IntegerPropertySchema
 LogoutResponse
 FileSystemCapabilities
 ElicitationAcceptAction
 ElicitationPropertySchema
 McpCapabilities
 ClientNotification
 ExtResponse
 EnumOption
 AuthenticateResponse
 ErrorCode
 MultiSelectPropertySchema
 ElicitationFormMode
 AgentRequest
 StringPropertySchema
 StringMultiSelectItems
 ElicitationSchema
 InitializeResponse
 NumberPropertySchema
 ElicitationUrlMode
 CompleteElicitationNotification
 ProtocolVersion
 ElicitationUrlCapabilities
 BooleanPropertySchema
 AuthMethodAgent
 AgentCapabilities
 ElicitationRequestScope
 Implementation
 StringFormat
 CancelRequestNotification
 AuthMethodId
 ElicitationId
 MultiSelectItems
 AgentNotification
 TitledMultiSelectItems
 ElicitationCapabilities
 Error
 ElicitationSessionScope
 PromptCapabilities
 ReadTextFileRequest
 ClientResponse
 AgentAuthCapabilities
 AuthMethodTerminal
 CreateElicitationResponse
 ElicitationContentValue
 LogoutCapabilities
 ExtNotification
 ClientCapabilities
 ClientRequest
)

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
;; ExtResponse
;; -------------------------------------------------------------------------

(def ExtResponse
  "Allows for sending an arbitrary response to an extension request that is not part of the ACP spec. Extension methods provide a way to add custom functionality while maintaining protocol compatibility. See protocol docs: [Extensibility](https://agentclientprotocol.com/protocol/v1/extensibility)"
  :any)

(def ->ExtResponse
  "Create a `ExtResponse` value."
  (rt/make-value-constructor #'ExtResponse "ExtResponse"))

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
;; ProtocolVersion
;; -------------------------------------------------------------------------

(def ProtocolVersion
  "Protocol version identifier. This version is only bumped for breaking changes. Non-breaking changes should be introduced via capabilities."
  [:int {:min 0, :max 65535}])

(def ->ProtocolVersion
  "Create a `ProtocolVersion` value."
  (rt/make-value-constructor #'ProtocolVersion "ProtocolVersion"))

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
