(ns acp.schema.fs
  "File system schemas for the `fs/read_text_file` and
  `fs/write_text_file` client methods."
  (:require [acp.schema-runtime :as rt]
            [acp.schema.common :as common]))


;; Schemas refer to one another, so declare every name up front.
(declare
 FileSystemCapabilities
 ReadTextFileRequest
 ReadTextFileResponse
 WriteTextFileRequest
 WriteTextFileResponse)


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
;; ReadTextFileRequest
;; -------------------------------------------------------------------------

(def ReadTextFileRequest
  "Request to read content from a text file. Only available if the client supports the `fs.readTextFile` capability."
  [:map
   {:closed false}
   [:sessionId #'common/SessionId]
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
;; WriteTextFileRequest
;; -------------------------------------------------------------------------

(def WriteTextFileRequest
  "Request to write content to a text file. Only available if the client supports the `fs.writeTextFile` capability."
  [:map
   {:closed false}
   [:sessionId #'common/SessionId]
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
