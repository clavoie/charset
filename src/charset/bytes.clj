(ns charset.bytes
  "Functions used to get the bytes of a value in a particular charset"
  (:require [charset.core :refer [ascii utf-8 utf-16]])
  (:import [java.nio.charset Charset]))

(defn get-bytes
  "Calls .getBytes() on value. If no charset is specified the default charset
  is used. Returns byte[]

  value   - (String) the value to get he bytes of
  charset - (String/Charset) either the name of a Charset or an instance
            of the Charset class. Throws an IllegalArgumentException if charset
            is neither.
  "
  ([^String value] (.getBytes value))
  ([^String value charset]
   (cond
    (string? charset) (.getBytes value (str charset))
    (instance? Charset charset) (.getBytes value ^Charset charset)
    true (throw (IllegalArgumentException. "The charset parameter must be either a String or an instance of the Charset class")))))

(defn ascii-bytes
  "Returns value encoded as an ascii byte[]

  value - the value to get the bytes of"
  [value]
  (get-bytes value ascii))

(defn utf8-bytes
  "Returns value encoded as a utf-8 byte[]

  value - the value to get the bytes of"
  [value]
  (get-bytes value utf-8))

(defn utf16-bytes
  "Returns value encoded as a utf-16 byte[]

  value - the value to get the bytes of"
  [value]
  (get-bytes value utf-16))
