module FindAWriterSpec where

import Test.Hspec
import FindAWriter

main :: IO ()
main = hspec $ do
  describe "findAWriter" $ do
    describe "given an encoded message and a key" $ do
      it "should return the decoded message" $
        (findAWriter ["osSE5Gu0Vi8WRq93UvkYZCjaOKeNJfTyH6tzDQbxFm4M1ndXIPh27wBA rLclpg",
                      "3 35 27 62 51 27 46 57 26 10 46 63 57 45 15 43 53"])
        `shouldBe`
        "Stephen King 1947"
