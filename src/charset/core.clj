(ns charset.core
  (:import [java.nio.charset Charset]))

(def ascii (Charset/forName "US-ASCII"))
(def iso-latin-1 (Charset/forName "ISO-8859-1"))
(def utf-8 (Charset/forName "UTF-8"))
(def utf-16-be (Charset/forName "UTF-16BE"))
(def utf-16-le (Charset/forName "UTF-16LE"))
(def utf-16 (Charset/forName "UTF-16"))
(def default-charset (Charset/defaultCharset))

(defn- to-entry
  ""
  [[key value]]
  [key value])

(defn all-charsets
  ""
  []
  (apply conj {} (map to-entry (Charset/availableCharsets))))

(defn get-charset
  ""
  [charset-name]
  (Charset/forName charset-name))

(defn supported?
  ""
  [charset-name]
  (Charset/isSupported charset-name))

(defn aliases
  ""
  [charset]
  (set (.aliases charset)))

(defn charset-name
  ""
  [charset]
  (.name charset))

(defn decoder
  ""
  [charset]
  (.newDecoder charset))

(defn encode?
  ""
  [charset]
  (.canEncode charset))

(defn encoder
  ""
  [charset]
  (.newEncoder charset))

(defn display-name
  ""
  [charset]
  (.displayName charset))

(defn registered?
  ""
  [charset]
  (.isRegistered charset))
