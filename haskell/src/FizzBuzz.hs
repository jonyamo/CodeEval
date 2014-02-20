-- CodeEval requires all modules to be called Main.
-- module Main where
module FizzBuzz where

import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines        -- String   : join lines with separating newlines
         $ map unwords    -- String   : join words with separating spaces
         $ map process    -- [String] : process each list of words
         $ map words      -- [String] : create a list of words
         $ lines contents -- [String] : create a list of lines

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
  | x `mod` f  == 0 = "F"
  | x `mod` b  == 0 = "B"
  | otherwise       = show x
