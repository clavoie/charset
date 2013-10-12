(ns charset.core
  "Details of the methods this namespace encapsulates can be found here:
   http://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html"
  (:import [java.nio.charset Charset]))

(def ascii "The ASCII charset object" (Charset/forName "US-ASCII"))
(def iso-latin-1 "The ISO Latin-1 charset object" (Charset/forName "ISO-8859-1"))
(def utf-8 "The UTF-8 charset object" (Charset/forName "UTF-8"))
(def utf-16-be "The UTF-16BE charset object" (Charset/forName "UTF-16BE"))
(def utf-16-le "The UTF-16LE charset object" (Charset/forName "UTF-16LE"))
(def utf-16 "The UTF-16 charset object" (Charset/forName "UTF-16"))
(def default-charset "Default charset object of this JVM" (Charset/defaultCharset))

(defn all-charsets
  "Returns all Charsets available for this system as a Clojure map. See for details:
   http://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html#availableCharsets()"
  []
  (apply conj (sorted-map) (Charset/availableCharsets)))

(defn get-charset
  "Returns a Charset object for a given name. The name is not
   case sensitive. See for details:
   http://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html#forName(java.lang.String)"
  [charset-name]
  (Charset/forName charset-name))

(defn supported?
  "Tests if a charset name is supported. See for details:
   http://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html#isSupported(java.lang.String)"
  [charset-name]
  (Charset/isSupported charset-name))

(defn aliases
  "Lists the aliases of a Charset returned as a Clojure set"
  [charset]
  (set (.aliases charset)))

(defn charset-name
  "Returns the name of a Charset"
  [charset]
  (.name charset))

(defn decoder
  "Creates a new CharsetDecoder object. See for details:
   http://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html#newDecoder()"
  [charset]
  (.newDecoder charset))

(defn encode?
  "Tests if this Charset supports encoding."
  [charset]
  (.canEncode charset))

(defn encoder
  "Creates a new CharsetEncoder object. See for details:
   http://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html#newEncoder()"
  [charset]
  (.newEncoder charset))

(defn display-name
  "Returns the display name of a Charset"
  [charset]
  (.displayName charset))

(defn registered?
  "Tells whether or not this Charset is registered in the IANA Charset Registry.
   See for details:
   http://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html#isRegistered()"
  [charset]
  (.isRegistered charset))
