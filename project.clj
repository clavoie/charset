(defproject charset "1.2.1"
  :description "Clojure wrappers around java.nio.charset.Charset"
  :url "https://github.com/clavoie/charset.git"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :global-vars {*warn-on-reflection* true}
  :plugins [[codox "0.6.6"]]
  :codox {:src-dir-uri "http://github.com/clavoie/charset/blob/master/"
          :src-linenum-anchor-prefix "L"})
