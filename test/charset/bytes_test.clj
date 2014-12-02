(ns charset.bytes-test
  (:use clojure.test
        charset.bytes)
  (:require
    [charset.core :refer [ascii]]))

(def byte-array-class (Class/forName "[B"))

(defn- byte-array?
  [object]
  (= byte-array-class (type object)))

(deftest test-get-bytes
  (is (byte-array? (get-bytes "test string")))
  (is (thrown? Exception (get-bytes :whoops)))
  (is (byte-array? (get-bytes "test string" "ascii")))
  (is (byte-array? (get-bytes "test string" ascii)))
  (is (thrown? Exception (get-bytes :whoops ascii)))
  (is (thrown? Exception (get-bytes "test string" :whoops))))

(deftest test-ascii-bytes
  (is (byte-array? (ascii-bytes "test-string")))
  (is (thrown? Exception (ascii-bytes :whoops))))

(deftest test-utf8-bytes
  (is (byte-array? (utf8-bytes "test-string")))
  (is (thrown? Exception (utf8-bytes :whoops))))

(deftest test-utf16-bytes
  (is (byte-array? (utf16-bytes "test string")))
  (is (thrown? Exception (utf16-bytes :whoops))))
