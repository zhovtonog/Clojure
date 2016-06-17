(ns om-mcp-volt.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(println "This text is printed from src/om-mcp-volt/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


(defn start-page [data owner]
  (reify
    om/IRender
    (render [_]
        (dom/h1 nil (:text data)))))

(om/root
  start-page
  app-state
  {:target (. js/document (getElementById "app"))})


(defroute index-page "/" []
  (om/root start-page
           app-state
           {:target (. js/document (getElementById "app"))}))

(defroute index-page "/home" []
  (om/root start-page
           app-state
           {:target (. js/document (getElementById "app"))}))

(defroute index-page "/account" []
  (om/root start-page
           app-state
           {:target (. js/document (getElementById "app"))}))



(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
