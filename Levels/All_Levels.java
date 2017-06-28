package Levels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class All_Levels implements Serializable{
	private transient ArrayList<AbstractLevel> levels = new ArrayList<>();
	final int num = 12; 
	int levelcomplete;// number of levels
	public All_Levels() {
		levels.addAll(Arrays.asList(
				new Level1(), new Level2(),
				new Level3()
				,new Level4(), new Level5(), new Level6()
				,new Level7(), new Level8()
				, new Level9()
				,new Level10(), new Level11(), new Level12()
				));
		levelcomplete = 0;
	}
	
	public AbstractLevel getLevel(int i) {
		return levels.get(i);
	}
	public void level_unlock(int i){
		if (i>levelcomplete){
		levelcomplete = i;}
	}
	public int level_complete(){
	return levelcomplete;
	}

	public int getNum() {// TODO Auto-generated method stub
		return num;
	}
	
}
