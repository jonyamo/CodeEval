-- module Main where
module FizzBuzz where

import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines
         $ map unwords
         $ map process
         $ map words
         $ lines contents

process :: [String] -> [String]
process [f,b,n] =
  let num  = read n::Int
      fizz = read f::Int
      buzz = read b::Int
  in  [fizzBuzz x fizz buzz | x <- [1..num]]
process []    = []
process (_:_) = []

fizzBuzz :: Int -> Int -> Int -> String
fizzBuzz x f b
  |  x `mod` f == 0
  && x `mod` b == 0 = "FB"
  |  x `mod` f == 0 = "F"
  |  x `mod` b == 0 = "B"
  |  otherwise      = show x
