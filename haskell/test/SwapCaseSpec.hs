module SwapCaseSpec where

import Test.Hspec
import SwapCase

main :: IO ()
main = hspec $ do
  describe "process" $ do
    it "should return the right answer" $
      (process ["HeLLo","WoRld!"]) `shouldBe` ["hEllO", "wOrLD!"]

  describe "swapCase" $ do
    describe "when given a string" $ do
      it "should return the string with each char's case swapped" $
        (swapCase "qUUx") `shouldBe` "QuuX"
