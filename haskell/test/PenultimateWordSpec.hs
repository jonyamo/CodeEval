module PenultimateWordSpec where

import Test.Hspec
import PenultimateWord

main :: IO ()
main = hspec $ do
  describe "penultimateWord" $ do
    describe "when given a list of two words" $ do
      it "should return the first word" $
        (penultimateWord ["foo","bar"]) `shouldBe` "foo"

    describe "when given a list of more than two words" $ do
      it "should return the second to last word" $
        (penultimateWord ["foo","bar","baz","quux"]) `shouldBe` "baz"
