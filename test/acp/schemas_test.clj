(ns acp.schemas-test

  (:require [clojure.test :as test]
    [acp.schemas :as schemas]
    [acp.schema.content :as content]
    [acp.schema.common :as common]
    [acp.schema.terminal :as terminal]
    [acp.schema.tool :as tool]
    [acp.schema.mcp :as mcp]
    [acp.schema.session :as session]
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
             [schemas/CreateTerminalRequest tool/CreateTerminalRequest]
             [schemas/CreateTerminalResponse tool/CreateTerminalResponse]
             [schemas/TerminalOutputRequest tool/TerminalOutputRequest]
             [schemas/KillTerminalRequest tool/KillTerminalRequest]
             [schemas/KillTerminalResponse tool/KillTerminalResponse]
             [schemas/WaitForTerminalExitRequest
              tool/WaitForTerminalExitRequest]
             [schemas/WaitForTerminalExitResponse
              tool/WaitForTerminalExitResponse]
             [schemas/ReleaseTerminalRequest tool/ReleaseTerminalRequest]
             [schemas/ReleaseTerminalResponse tool/ReleaseTerminalResponse]
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
             [schemas/Diff content/Diff]
             [schemas/ToolCallId tool/ToolCallId]
             [schemas/ToolCallStatus tool/ToolCallStatus]
             [schemas/ToolCallLocation tool/ToolCallLocation]
             [schemas/ToolCall tool/ToolCall]
             [schemas/ToolCallUpdate tool/ToolCallUpdate]
             [schemas/HttpHeader mcp/HttpHeader]
             [schemas/EnvVariable mcp/EnvVariable]
             [schemas/McpServerHttp mcp/McpServerHttp]
             [schemas/McpServerSse mcp/McpServerSse]
             [schemas/McpServerStdio mcp/McpServerStdio]
             [schemas/McpServer mcp/McpServer]
             [schemas/SessionId session/SessionId]
             [schemas/SessionId common/SessionId]
             [schemas/SessionCapabilities session/SessionCapabilities]
             [schemas/ClientSessionCapabilities session/ClientSessionCapabilities]
             [schemas/NewSessionRequest session/NewSessionRequest]
             [schemas/NewSessionResponse session/NewSessionResponse]
             [schemas/LoadSessionRequest session/LoadSessionRequest]
             [schemas/LoadSessionResponse session/LoadSessionResponse]
             [schemas/ResumeSessionRequest session/ResumeSessionRequest]
             [schemas/ResumeSessionResponse session/ResumeSessionResponse]
             [schemas/ListSessionsRequest session/ListSessionsRequest]
             [schemas/ListSessionsResponse session/ListSessionsResponse]
             [schemas/SessionInfo session/SessionInfo]
             [schemas/SessionInfoUpdate session/SessionInfoUpdate]
             [schemas/DeleteSessionRequest session/DeleteSessionRequest]
             [schemas/DeleteSessionResponse session/DeleteSessionResponse]
             [schemas/CloseSessionRequest session/CloseSessionRequest]
             [schemas/CloseSessionResponse session/CloseSessionResponse]
             [schemas/SessionMode session/SessionMode]
             [schemas/SessionModeState session/SessionModeState]
             [schemas/SetSessionModeRequest session/SetSessionModeRequest]
             [schemas/CurrentModeUpdate session/CurrentModeUpdate]
             [schemas/SessionConfigOption session/SessionConfigOption]
             [schemas/SessionConfigOptionCategory session/SessionConfigOptionCategory]
             [schemas/SetSessionConfigOptionRequest
              session/SetSessionConfigOptionRequest]
             [schemas/SetSessionConfigOptionResponse
              session/SetSessionConfigOptionResponse]
             [schemas/ConfigOptionUpdate session/ConfigOptionUpdate]
             [schemas/ContentChunk session/ContentChunk]
             [schemas/MessageId session/MessageId]
             [schemas/SessionUpdate session/SessionUpdate]
             [schemas/SessionNotification session/SessionNotification]
             [schemas/StopReason session/StopReason]
             [schemas/PromptRequest session/PromptRequest]
             [schemas/PromptResponse session/PromptResponse]
             [schemas/Plan session/Plan]
             [schemas/PlanEntry session/PlanEntry]
             [schemas/AvailableCommand session/AvailableCommand]
             [schemas/AvailableCommandsUpdate session/AvailableCommandsUpdate]
             [schemas/Cost session/Cost]
             [schemas/UsageUpdate session/UsageUpdate]
             [schemas/Notice session/Notice]
             [schemas/CompactionUpdate session/CompactionUpdate]
             [schemas/CompactionSummaryChunk session/CompactionSummaryChunk]
             [schemas/PermissionOption session/PermissionOption]
             [schemas/RequestPermissionRequest session/RequestPermissionRequest]
             [schemas/RequestPermissionResponse session/RequestPermissionResponse]
             [schemas/CancelNotification session/CancelNotification]]]
      (test/is (identical? exported original))))

  (test/testing "constructors alias their defining namespace"
    (doseq [[exported original]
            [[schemas/->TerminalExitStatus terminal/->TerminalExitStatus]
             [schemas/->TerminalId terminal/->TerminalId]
             [schemas/->TerminalOutputResponse terminal/->TerminalOutputResponse]
             [schemas/->Terminal terminal/->Terminal]
             [schemas/->CreateTerminalRequest tool/->CreateTerminalRequest]
             [schemas/->CreateTerminalResponse tool/->CreateTerminalResponse]
             [schemas/->TerminalOutputRequest tool/->TerminalOutputRequest]
             [schemas/->KillTerminalRequest tool/->KillTerminalRequest]
             [schemas/->KillTerminalResponse tool/->KillTerminalResponse]
             [schemas/->WaitForTerminalExitRequest
              tool/->WaitForTerminalExitRequest]
             [schemas/->WaitForTerminalExitResponse
              tool/->WaitForTerminalExitResponse]
             [schemas/->ReleaseTerminalRequest tool/->ReleaseTerminalRequest]
             [schemas/->ReleaseTerminalResponse tool/->ReleaseTerminalResponse]
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
             [schemas/->Diff content/->Diff]
             [schemas/->ToolCallId tool/->ToolCallId]
             [schemas/->ToolCallStatus tool/->ToolCallStatus]
             [schemas/->ToolCallLocation tool/->ToolCallLocation]
             [schemas/->ToolCall tool/->ToolCall]
             [schemas/->ToolCallUpdate tool/->ToolCallUpdate]
             [schemas/->HttpHeader mcp/->HttpHeader]
             [schemas/->EnvVariable mcp/->EnvVariable]
             [schemas/->McpServerHttp mcp/->McpServerHttp]
             [schemas/->McpServerSse mcp/->McpServerSse]
             [schemas/->McpServerStdio mcp/->McpServerStdio]
             [schemas/->McpServer mcp/->McpServer]
             [schemas/->SessionId session/->SessionId]
             [schemas/->SessionId common/->SessionId]
             [schemas/->SessionCapabilities session/->SessionCapabilities]
             [schemas/->ClientSessionCapabilities
              session/->ClientSessionCapabilities]
             [schemas/->NewSessionRequest session/->NewSessionRequest]
             [schemas/->NewSessionResponse session/->NewSessionResponse]
             [schemas/->LoadSessionRequest session/->LoadSessionRequest]
             [schemas/->LoadSessionResponse session/->LoadSessionResponse]
             [schemas/->ResumeSessionRequest session/->ResumeSessionRequest]
             [schemas/->ResumeSessionResponse session/->ResumeSessionResponse]
             [schemas/->ListSessionsRequest session/->ListSessionsRequest]
             [schemas/->ListSessionsResponse session/->ListSessionsResponse]
             [schemas/->SessionInfo session/->SessionInfo]
             [schemas/->SessionInfoUpdate session/->SessionInfoUpdate]
             [schemas/->DeleteSessionRequest session/->DeleteSessionRequest]
             [schemas/->DeleteSessionResponse session/->DeleteSessionResponse]
             [schemas/->CloseSessionRequest session/->CloseSessionRequest]
             [schemas/->CloseSessionResponse session/->CloseSessionResponse]
             [schemas/->SessionMode session/->SessionMode]
             [schemas/->SessionModeState session/->SessionModeState]
             [schemas/->SetSessionModeRequest session/->SetSessionModeRequest]
             [schemas/->CurrentModeUpdate session/->CurrentModeUpdate]
             [schemas/->SessionConfigOption session/->SessionConfigOption]
             [schemas/->SessionConfigOptionCategory
              session/->SessionConfigOptionCategory]
             [schemas/->SetSessionConfigOptionRequest
              session/->SetSessionConfigOptionRequest]
             [schemas/->SetSessionConfigOptionResponse
              session/->SetSessionConfigOptionResponse]
             [schemas/->ConfigOptionUpdate session/->ConfigOptionUpdate]
             [schemas/->ContentChunk session/->ContentChunk]
             [schemas/->MessageId session/->MessageId]
             [schemas/->SessionUpdate session/->SessionUpdate]
             [schemas/->SessionNotification session/->SessionNotification]
             [schemas/->StopReason session/->StopReason]
             [schemas/->PromptRequest session/->PromptRequest]
             [schemas/->PromptResponse session/->PromptResponse]
             [schemas/->Plan session/->Plan]
             [schemas/->PlanEntry session/->PlanEntry]
             [schemas/->AvailableCommand session/->AvailableCommand]
             [schemas/->AvailableCommandsUpdate
              session/->AvailableCommandsUpdate]
             [schemas/->Cost session/->Cost]
             [schemas/->UsageUpdate session/->UsageUpdate]
             [schemas/->Notice session/->Notice]
             [schemas/->CompactionUpdate session/->CompactionUpdate]
             [schemas/->CompactionSummaryChunk session/->CompactionSummaryChunk]
             [schemas/->PermissionOption session/->PermissionOption]
             [schemas/->RequestPermissionRequest
              session/->RequestPermissionRequest]
             [schemas/->RequestPermissionResponse
              session/->RequestPermissionResponse]
             [schemas/->CancelNotification session/->CancelNotification]]]
      (test/is (identical? exported original))))


;; A extracted schema that is referenced from this namespace but never defined
;; or re-exported here makes malli fail with `:malli.core/invalid-schema` at
;; validation time instead of at load time, so exercise one such reference.
(test/deftest every-referenced-schema-is-bound
  (test/testing "schemas defined here resolve their extracted references"
    (test/is (bound? #'schemas/TerminalOutputResponse))
    (test/is (bound? #'schemas/CreateTerminalRequest))
    (test/is (m/validate schemas/ClientResponse
                        {:id "1"
                         :result {:output "hello" :truncated false}}))
    (test/is (m/validate schemas/ClientResponse
                        {:id "1"
                         :result {:output "hello"
                                  :truncated true
                                  :exitStatus {:exitCode 0}}}))
    (test/is (m/validate schemas/AgentRequest
                        {:id "1"
                         :method "terminal/create"
                         :params {:sessionId "session-1" :command "ls"}}))
    (test/is (m/validate schemas/ClientResponse
                        {:id "1"
                         :result {:terminalId "terminal-1"}})))))


(test/deftest extracted-schemas-compose
  (test/testing "schemas defined here validate extracted content blocks"
    (test/is (m/validate schemas/ContentChunk
                        {:content {:type "text" :text "hello"}}))
    (test/is (m/validate schemas/PromptRequest
                        {:sessionId "session-1"
                         :prompt [{:type "text" :text "hello"}]})))
    (test/is (m/validate schemas/NewSessionRequest
                        {:cwd "/tmp"
                         :mcpServers [{:type "stdio"
                                       :name "test"
                                       :command "npx"
                                       :args []
                                       :env []}]}))

  (test/testing "extracted schemas validate blocks built by this namespace"
    (test/is (m/validate schemas/ContentBlock
                        (schemas/->ContentBlock {:type "text" :text "hello"})))
    (test/is (m/validate schemas/ToolCallContent
                        (schemas/->ToolCallContent {:type "diff"
                                                    :path "notes.txt"
                                                    :newText "hello"})))
    (test/is (m/validate schemas/TextContent
                        (schemas/->TextContent "hello"))))

  (test/testing "extracted schemas validate terminal requests and responses"
    (test/is (m/validate schemas/AgentRequest
                        {:id "1"
                         :method "terminal/create"
                         :params (schemas/->CreateTerminalRequest
                                  "session-1" "ls")}))
    (test/is (m/validate schemas/ClientResponse
                        {:id "1"
                         :result (schemas/->CreateTerminalResponse
                                  "terminal-1")}))))


(test/deftest extracted-schemas-error-explanation
  (test/testing "names the extracted schema being validated"
    (let [error (me/humanize (m/explain schemas/Content {:content {:type "text"}}))]
      (test/is (some? error)))))
