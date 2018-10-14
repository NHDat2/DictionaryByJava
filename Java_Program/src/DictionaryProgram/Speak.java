package DictionaryProgram;

/**
 * class Speak is use to speak word
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */
public class Speak {
    public void doSpeak(String inputString){
        //Create TextToSpeech
        TextToSpeech tts = new TextToSpeech();
        //Print all the available audio effects
        // Setting the Voice
        tts.setVoice("cmu-slt-hsmm");
        // TTS say something that we actually are typing into the first variable
        tts.speak(inputString, 2.0f, false, true);

    }

}