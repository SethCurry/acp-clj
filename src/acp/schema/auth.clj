(ns acp.schema.auth
  "Authentication method and capability schemas, plus the `authenticate`
  and `logout` method requests and responses."
  (:require [acp.schema-runtime :as rt]))


;; Schemas refer to one another, so declare every name up front.
(declare
 AgentAuthCapabilities
 AuthCapabilities
 AuthMethod
 AuthMethodAgent
 AuthMethodId
 AuthMethodTerminal
 AuthenticateRequest
 AuthenticateResponse
 LogoutCapabilities
 LogoutRequest
 LogoutResponse)


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
;; AuthMethodId
;; -------------------------------------------------------------------------

(def AuthMethodId
  "Typed identifier used for auth method values on the wire."
  :string)

(def ->AuthMethodId
  "Create a `AuthMethodId` value."
  (rt/make-value-constructor #'AuthMethodId "AuthMethodId"))


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
