(ns acp.schema.elicitation
  "Elicitation schemas: the requests, responses and capabilities for
  asking the user for structured input, plus the JSON-Schema subset that
  describes the fields of an elicitation form."
  (:require [acp.schema-runtime :as rt]
            [acp.schema.common :as common]
            [acp.schema.tool :as tool]))


;; Schemas refer to one another, so declare every name up front.
(declare
 BooleanPropertySchema
 CompleteElicitationNotification
 CreateElicitationRequest
 CreateElicitationResponse
 ElicitationAcceptAction
 ElicitationCapabilities
 ElicitationContentValue
 ElicitationFormCapabilities
 ElicitationFormMode
 ElicitationId
 ElicitationPropertySchema
 ElicitationRequestScope
 ElicitationSchema
 ElicitationSchemaType
 ElicitationSessionScope
 ElicitationUrlCapabilities
 ElicitationUrlMode
 EnumOption
 IntegerPropertySchema
 MultiSelectItems
 MultiSelectPropertySchema
 NumberPropertySchema
 StringFormat
 StringMultiSelectItems
 StringPropertySchema
 TitledMultiSelectItems)


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
;; ElicitationId
;; -------------------------------------------------------------------------

(def ElicitationId
  "Unique identifier for an elicitation."
  :string)

(def ->ElicitationId
  "Create a `ElicitationId` value."
  (rt/make-value-constructor #'ElicitationId "ElicitationId"))


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
;; ElicitationRequestScope
;; -------------------------------------------------------------------------

(def ElicitationRequestScope
  "Request-scoped elicitation, tied to a specific JSON-RPC request outside of a session (e.g., during auth/configuration phases before any session is started)."
  [:map {:closed false} [:requestId #'common/RequestId]])

(def ->ElicitationRequestScope
  "Create a `ElicitationRequestScope` value."
  (rt/make-object-constructor
    #'ElicitationRequestScope
    "ElicitationRequestScope"
    [{:key :requestId, :required? true, :nullable? false}]
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
;; ElicitationSessionScope
;; -------------------------------------------------------------------------

(def ElicitationSessionScope
  "Session-scoped elicitation, optionally tied to a specific tool call. When `toolCallId` is set, the elicitation is tied to a specific tool call. This is useful when an agent receives an elicitation from an MCP server during a tool call and needs to redirect it to the user."
  [:map
   {:closed false}
   [:sessionId #'common/SessionId]
   [:toolCallId {:optional true} [:maybe #'tool/ToolCallId]]])

(def ->ElicitationSessionScope
  "Create a `ElicitationSessionScope` value."
  (rt/make-object-constructor
    #'ElicitationSessionScope
    "ElicitationSessionScope"
    [{:key :sessionId, :required? true, :nullable? false}
     {:key :toolCallId, :required? false, :nullable? true}]
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
;; StringFormat
;; -------------------------------------------------------------------------

(def StringFormat
  "String format types for string properties in elicitation schemas."
  [:enum "email" "uri" "date" "date-time"])

(def ->StringFormat
  "Create a `StringFormat` value."
  (rt/make-value-constructor #'StringFormat "StringFormat"))


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
