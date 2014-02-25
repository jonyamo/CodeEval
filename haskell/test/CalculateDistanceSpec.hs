module CalculateDistanceSpec where

import Test.Hspec
import CalculateDistance

main :: IO ()
main = hspec $ do
  describe "getNumbers" $ do
    describe "given a string" $ do
      it "should return a list of extracted numbers" $
        (getNumbers "(47, 43) (-25, -11)") `shouldBe` ["47","43","-25","-11"]

  describe "getDistance" $ do
    describe "given a list of four numeric strings (representing two points)" $ do
      it "should return the distance between the two points" $
        (getDistance ["47","43","-25","-11"]) `shouldBe` "90"

  describe "getDistance'" $ do
    describe "given four numbers (representing two points)" $ do
      it "should return the distance between the two points" $
        (getDistance' 25 4 1 (-6)) `shouldBe` 26

