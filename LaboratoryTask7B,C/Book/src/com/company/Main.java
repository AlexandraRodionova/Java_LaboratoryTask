package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = null;
        Paragraph[] paragraphs;
        int numberOfParagraphs;
        Sentence[] sentences;
        int numberOfSentences;
        Word[] words;
        int numberOfWords;
        Symbol[] symbols;
        int numberOfSymbols;
        PunctuationMark[] punctuationMarks;
        int numberOfPunctuationMarks;
        try {
            FileReader fr = new FileReader("text\\book.txt");
            scanner = new Scanner(fr);
            StringBuilder text = new StringBuilder("");
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine()).append("\n");
            }
            //Paragraphs
            Pattern paragraphPattern = Pattern.compile("\n");
            numberOfParagraphs = paragraphPattern.split(text).length;
            paragraphs = new Paragraph[numberOfParagraphs];
            for (int i = 0; i < numberOfParagraphs; i++) {
                paragraphs[i] = new Paragraph(paragraphPattern.split(text)[i]);
            }
            //Sentences
            Pattern sentencesPattern = Pattern.compile("[.!?;:]" + "[ \\n]");
            numberOfSentences = sentencesPattern.split(text).length;
            sentences = new Sentence[numberOfSentences];
            for (int i = 0; i < numberOfSentences; i++) {
                sentences[i] = new Sentence(sentencesPattern.split(text)[i]);
            }
            //Words
            Pattern wordsPattern = Pattern.compile("[\\p{Punct} —⦁«»\\n\t\\p{Alnum}\f]+");
            numberOfWords = wordsPattern.split(text).length;
            words = new Word[numberOfWords];
            for (int i = 0; i < numberOfWords; i++) {
                words[i] = new Word(wordsPattern.split(text)[i]);
            }
            //Symbols
            Pattern symbolsPattern = Pattern.compile("[\\p{Punct} —⦁«»\\n\t]*");
            numberOfSymbols = symbolsPattern.split(text).length;
            symbols = new Symbol[numberOfSymbols];
            for (int i = 0; i < numberOfSymbols; i++) {
                symbols[i] = new Symbol(symbolsPattern.split(text)[i]);
            }
            //Punctuation Marks
            Pattern punctuationPattern = Pattern.compile("[^\\p{Punct}]+");
            numberOfPunctuationMarks = punctuationPattern.split(text).length;
            punctuationMarks = new PunctuationMark[numberOfPunctuationMarks];
            for (int i = 0; i < numberOfPunctuationMarks; i++) {
                punctuationMarks[i] = new PunctuationMark(punctuationPattern.split(text)[i]);
            }
            //Task B
            char ch = 'а';
            for (int i = 0; i < numberOfWords + 1; i++) {
                for (int j = 0; j < numberOfWords - 1; j++) {
                    if (words[j].numberOfSymbol(ch) > words[j + 1].numberOfSymbol(ch)) {
                        Word word = words[j];
                        words[j] = words[j + 1];
                        words[j + 1] = word;
                    } else if (words[j].numberOfSymbol(ch) == words[j + 1].numberOfSymbol(ch) && words[j].biggerThan(words[j + 1])) {
                        Word word = words[j];
                        words[j] = words[j + 1];
                        words[j + 1] = word;
                    }
                }
            }
            for (int i = 0; i < numberOfWords; i++) {
                System.out.println(words[i].word + " (" + words[i].numberOfSymbol(ch) + ")");
            }
            //Task C
            StringBuilder formattedText = new StringBuilder("  ");
            fr = new FileReader("text\\book.txt");
            scanner = new Scanner(fr);

            while (scanner.hasNextLine()) {
                formattedText.append("  ");
                int length = 4;
                String word = scanner.nextLine();
                String[] newWords=word.split(" ");
                for (String newWord : newWords) {
                    length += newWord.length();
                    if (length > 128) {
                        formattedText.append("\n");
                        formattedText.append("  ");
                        formattedText.append(newWord);
                        length = 2 + newWord.length();
                    } else {
                        formattedText.append("  ");
                        formattedText.append(newWord);
                        length += 2;
                    }
                }
                formattedText.append("\n");
            }
            try (FileWriter fw = new FileWriter("text\\Formatted text.txt")) {
                fw.write(formattedText.toString());
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}
