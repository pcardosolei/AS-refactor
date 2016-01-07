package Observer;

public interface Subject {

	void notifyApostadores(int evento);
        void register(Observer o);

}