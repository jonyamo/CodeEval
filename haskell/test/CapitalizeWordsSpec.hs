module CapitalizeWordsSpec where

import Test.Hspec
import CapitalizeWords

main :: IO ()
main = hspec $ do
  describe "capitalizeWords" $ do
    describe "when given a list of strings" $ do
      it "should return the list with each string capitalized" $
        (capitalizeWords ["foo","bar"]) `shouldBe` ["Foo", "Bar"]

  describe "capitalizeWord" $ do
    describe "when given a string" $ do
      it "should return the string capitalized" $
        (capitalizeWord "quux") `shouldBe` "Quux"
