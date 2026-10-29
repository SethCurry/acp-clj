(ns acp.schema.content
  (:require [acp.schema-runtime :as rt]))


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
;; TextContent
;; -------------------------------------------------------------------------

(def TextContent
  "Text provided to or from an LLM."
  [:map
   {:closed false}
   [:annotations {:optional true} [:maybe #'Annotations]]
   [:text :string]
   [:_meta {:optional true} [:maybe [:map {:closed false}]]]])

(defn ->TextContent
  "Create a `TextContent` value."
  [text]
  (let [value {
      :text text
      :annotations nil
      :_meta nil
    }]
    (rt/validate! #'TextContent value "TextContent")
    value))


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
