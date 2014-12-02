(ns charset.bytes
  "Functions used to get the bytes of a value in a particular charset"
  (:require [charset.core :refer [ascii utf-8 utf-16]]))

(defn get-bytes
  "Calls .getBytes() on value. The charset argument can be a
   java.nio.charset.Charset object or the String name of a charset,
   such as \"utf-8\". If no charset is specified the default
   charset is used. Returns byte[]"
  ([value] (.getBytes value))
  ([value charset] (.getBytes value charset)))

(defn ascii-bytes
  "Returns value encoded as an ascii byte[]"
  [value]
  (get-bytes value ascii))

(defn utf8-bytes
  "Returns value encoded as a utf-8 byte[]"
  [value]
  (get-bytes value utf-8))

(defn utf16-bytes
  "Returns value encoded as a utf-16 byte[]"
  [value]
  (get-bytes value utf-16))
