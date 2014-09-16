(defproject paintball-clj "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [compojure "1.1.8"]
                           [ring/ring-core "1.2.0"]
                           [ring/ring-jetty-adapter "1.2.2"]
                           [environ "0.5.0"]]
            :plugins [[lein-ring "0.8.11"]
                      [environ/environ.lein "0.2.1"]]
            :min-lein-version "2.0.0"
            :hooks [environ.leiningen.hooks]
            :ring {:handler paintball-clj.handler/app}
            :uberjar-name "paintball-clj-standalone.jar"
            :profiles {:production {:env {:production true}}})
