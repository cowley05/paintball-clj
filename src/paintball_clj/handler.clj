(ns paintball-clj.handler
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [resource-response response]]

            [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]))

(defroutes app
           (GET "/" [] (resource-response "index.html" {:root "public"}))
           (route/resources "/")
           (route/not-found "Not Found"))

#_(def app
  (site app-routes))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))

