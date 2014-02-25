module EvenNumbersSpec where

import Test.Hspec
import EvenNumbers

main :: IO ()
main = hspec $ do
  describe "oneForEvenZeroForOdd" $ do
    describe "given a numeric string" $ do
      it "should return 1 if the number is even" $
        (oneForEvenZeroForOdd "888") `shouldBe` "1"

      it "should return 0 if the number is odd" $
        (oneForEvenZeroForOdd "777") `shouldBe` "0"
