package Observer;

import Controllers.ApostaController;
import Models.Resultado;

public interface Observer {

	void update(ApostaController apostas,Resultado resultado);

}