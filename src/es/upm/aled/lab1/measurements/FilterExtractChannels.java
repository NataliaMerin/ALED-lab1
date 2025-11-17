package es.upm.aled.lab1.measurements;

import java.util.ArrayList;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {

	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	private int[] validChannels; //atributos de la clase FilterExtractChannels
	
	public FilterExtractChannels(int[] validChannels) { //Es el constructor de la clase  FilterExtractChannels.
		this.validChannels = validChannels; // this. se refiere al atributo y le damos el valor que querremos asociar a nuestro objeto.
		//TODO*

	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		EEGModel eegF = new EEGModel();
		float[]canales = new float[validChannels.length];
		int j=0;
		for(int i=0; i<eeg.getMeasurements().length;i++) {
			Measurement m = eeg.getMeasurements()[i];
			for(int v=0; v< validChannels.length; v++) {	 
				float valor=m.getChannel(v);
				canales[j]= valor;
				j++;
			}
			Measurement mNuevo= new Measurement(canales);//aqui quiero meter los canales filtrados
			eegF.addMeasurement(mNuevo);
		}
		// TODO*
		return eegF;
	}

}
