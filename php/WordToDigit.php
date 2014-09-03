<?php
namespace CodeEval;

class WordToDigit
{
    const ZERO  = 0;
    const ONE   = 1;
    const TWO   = 2;
    const THREE = 3;
    const FOUR  = 4;
    const FIVE  = 5;
    const SIX   = 6;
    const SEVEN = 7;
    const EIGHT = 8;
    const NINE  = 9;

    protected $words;

    public function __construct(array $words=array())
    {
        $this->words = $words;
    }

    public function getDigits()
    {
        return array_map(function($w) {
            return constant(__CLASS__ . "::" . strtoupper($w));
        }, $this->words);
    }

    public static function loadFromFile($filename)
    {
        $lines = file($filename,
            FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
        if ($lines === false) {
            throw new \Exception("Invalid file: {$filename}");
        }
        $wtds = array();
        foreach ($lines as $line) {
            $words = explode(";", trim($line));
            $wtds[] = new \CodeEval\WordToDigit($words);
        }
        return $wtds;
    }
}

$wtds = \CodeEval\WordToDigit::loadFromFile($argv[1]);
foreach ($wtds as $wtd) {
    fwrite(STDOUT, implode("", $wtd->getDigits()) . PHP_EOL);
}
