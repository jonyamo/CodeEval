module SimpleSortingSpec where

import Test.Hspec
import SimpleSorting

main :: IO ()
main = hspec $ do
  describe "process" $ do
    it "should return the correct answer" $
      (process ["70.920","-38.797","14.354","99.323","90.374","7.581"])
      `shouldBe`
      ["-38.797","7.581","14.354","70.920","90.374","99.323"]
