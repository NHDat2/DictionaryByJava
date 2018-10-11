package DictionaryProgram;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * DictionaryManagement includes dictionary's manage methods
 */
class DictionaryManagement
{
    /**
     * insestFromCommandline to get input from commandline
     *@param inputCmd_Dictionary is the dictionary to add input to
     */
    public void insertFromCommandLine(Dictionary inputCmd_Dictionary)
    {
        Scanner scan = new Scanner(System.in);
        int numberOfWord = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numberOfWord; i++)
        {
            Word input_Word = new Word();
            String input, input2;
            input_Word.setWordTarget(input = scan.nextLine());
            input_Word.setWordExplain(input2 = scan.nextLine());
            inputCmd_Dictionary.addElement(input_Word);
        }
        scan.close();
    }

    public void insertFromFile(Dictionary inputTxt_Dictionary)
    {
        try
        {
            File path = new File("./resource/avdict.txt");
            FileReader readFile = new FileReader(path);
            BufferedReader bufferReader = new BufferedReader(readFile);
            String line;
            while ((line = bufferReader.readLine()) != null)
            {
                if(line.charAt(0) == '*') continue;
                Word input_Word = new Word();
                int index = line.lastIndexOf('\t');
                if (index == -1) continue;
                input_Word.setWordTarget(line.substring(0, index));
                input_Word.setWordExplain(line.substring(index + 1, line.length()));
                inputTxt_Dictionary.addElement(input_Word);
            }
            readFile.close();
            bufferReader.close();
        }
        catch (Exception er)
        {
            System.out.println("Error read file : " + er);
        }
    }

    public void addWords(Dictionary add_Dictionary){
        Scanner scan = new Scanner(System.in);
        Word added_Word = new Word();
        String added_WordTarget = "";
        String added_WordExplain = "";
        System.out.print("Enter your target word: ");
        added_WordTarget = scan.nextLine();
        System.out.print("Enter your explain word: ");
        added_WordExplain = scan.nextLine();
        added_Word.setWordTarget(added_WordTarget);
        added_Word.setWordExplain(added_WordExplain);
        add_Dictionary.addElement(added_Word);
        System.out.println("Added");
        try{
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception er){};
    }

    public void editWord(Dictionary edit_Dictionary){
        Scanner scan = new Scanner(System.in);
        Word replace_Word = new Word();
        String edit_WordTarget = "";
        String replace_WordTarget = "";
        String replace_WordExplain = "";
        System.out.print("Enter your word which needs editing: ");
        edit_WordTarget = scan.nextLine();
        System.out.print("Enter your edited target word: ");
        replace_WordTarget = scan.nextLine();
        System.out.print("Enter your edited explain word: ");
        replace_WordExplain = scan.nextLine();
        replace_Word.setWordTarget(replace_WordTarget);
        replace_Word.setWordExplain(replace_WordExplain);
        for (Word value : edit_Dictionary.list_word)
        {
            if (edit_WordTarget.equals(value.getWordTarget()))
            {
                value.setWordTarget(replace_Word.getWordTarget());
                value.setWordExplain(replace_Word.getWordExplain());
            }
        }
        System.out.println("Edited");
        try{
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception er){};
    }

    public void deleteWord(Dictionary delete_Dictionary){
        Scanner scan = new Scanner(System.in);
        String deleted_Word;
        System.out.println("Enter your word which needs deleting (target word only): ");
        deleted_Word = scan.nextLine();
        for (int i = 0; i < delete_Dictionary.list_word.size(); i++)
        {
            String delete_Target = delete_Dictionary.list_word.get(i).getWordTarget();
            if (delete_Target.equals(deleted_Word)){
                delete_Dictionary.list_word.remove(i);
            }
        }
        System.out.println("Deleted");
        try{
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception er){};
    }
    /**
     * updateFile to update fixed data
     */
    public void dictionaryExportToFile(Dictionary output_Dictionary){
        try{
            FileWriter writer = new FileWriter("./resource/Dictionaries.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            for (int i = 0; i < output_Dictionary.list_word.size(); i++)
            {
                String out_Target = output_Dictionary.list_word.get(i).getWordTarget();
                String out_Explain = output_Dictionary.list_word.get(i).getWordExplain();
                buffer.write(out_Target);
                buffer.write("\t");
                buffer.write(out_Explain);
                buffer.write("\n");
            }
            buffer.close();
            System.out.println("Changes saved...");
            try{
                TimeUnit.SECONDS.sleep(3);
            }
            catch (Exception er){};
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void dictionaryLookup(Dictionary find_Dictionary)
    {
        Scanner scan = new Scanner(System.in);
        String key_word;
        System.out.println("Enter your word: ");
        key_word = scan.nextLine();
        //scan.close();
        for (Word value : find_Dictionary.list_word)
        {
            if (key_word.equals(value.getWordTarget()))
            {
                System.out.println(value.getWordExplain());
            }
        }
    }
}
