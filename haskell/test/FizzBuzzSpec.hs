module FizzBuzzSpec where

import Test.Hspec
import FizzBuzz

main :: IO ()
main = hspec $ do
  describe "process" $ do
    it "should return the correct answer" $
      (process ["2","7","15"]) `shouldBe` ["1","F","3","F","5","F","B","F","9","F","11","F","13","FB","15"]

  describe "fizzBuzz" $ do
    describe "when given number is divisible by f" $ do
      it "should return F" $
        (fizzBuzz 3 3 5)  `shouldBe` "F"

    describe "when given number is divisible by b" $ do
      it "should return B" $
        (fizzBuzz 5 3 5)  `shouldBe` "B"

    describe "when given number is divisible by f and b" $ do
      it "should return FB" $
        (fizzBuzz 15 3 5)  `shouldBe` "FB"

    describe "when given number is not divisible by f nor b" $ do
      it "should return itself" $
        (fizzBuzz 7 3 5)  `shouldBe` "7"
