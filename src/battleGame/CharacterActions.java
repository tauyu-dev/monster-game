package battleGame;

public interface CharacterActions {

	void attack(Character target);
	void defend();
	boolean isDefending();
	boolean isAlive();
}

