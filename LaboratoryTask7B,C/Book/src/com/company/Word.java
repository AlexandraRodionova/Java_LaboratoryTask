package com.company;

public class Word {
    String word;
    Word(String word){
        this.word=word;
    }
    int numberOfSymbol(char ch){
        int n=0;
        int idx=0;
        while(word.indexOf(ch,idx)!=-1) {
            n++;
            idx+=word.indexOf(ch,idx)+1;
        }
        return n;
    }
    boolean biggerThan(Word word){
        boolean bool=false;
        int length=Math.min(word.word.length(),this.word.length());
        for(int i=0;i<length;i++){
            if(this.word.charAt(i)>word.word.charAt(i)) {
                bool = true;
                break;
            }else if(this.word.charAt(i)<word.word.charAt(i)){
                break;
            }
        }
        return bool;
    }
}
