package helpers;

import constants.Medicals;
import entity.*;
import entity.Package;
import util.DateUtil;

import java.math.BigDecimal;
import java.util.List;

public abstract class XmlStreamReader {

    protected List<Medicine> medicines;

    protected String thisElement;

    public Versions getLastVersion() {
        return getLastMedicine().getVersions().get(getLastMedicine().getVersions().size() - 1);
    }

    public Medicine getLastMedicine() {
        return getMedicines().get(medicines.size() - 1);
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void processCurrentElement() {
        thisElement = thisElement.intern();
        if (thisElement.equals(Medicals.MEDICINE.value())) {
            medicines.add(new Medicine());
        } else if (thisElement.equals(Medicals.VERSION.value())) {
            getLastMedicine().getVersions().add(new Versions());
        } else if (thisElement.equals(Medicals.CERTIFICATE.value())) {
            getLastVersion().setCertificate(new Certificate());
        } else if (thisElement.equals(Medicals.PACKAGE.value())) {
            getLastVersion().setMedicalPackage(new Package());
        } else if (thisElement.equals(Medicals.DOSAGE.value())) {
            getLastVersion().setDosage(new Dosage());
        }
    }
    public void processDataForCurrentElement(String internalText) {
        String data = internalText.intern();
        if (thisElement.equals(Medicals.NAME.value())) {
            getLastMedicine().setName(data);
        } else if (thisElement.equals(Medicals.PHARMACY.value())) {
            getLastMedicine().setPharmacy(data);
        } else if (thisElement.equals(Medicals.GROUP.value())) {
            getLastMedicine().setGroup(Group.fromValue(data));
        } else if (thisElement.equals(Medicals.ANALOG_NAME.value())) {
            getLastMedicine().getAnalogues().add(data);
        } else if (thisElement.equals(Medicals.NUMBER.value())) {
            getLastVersion().getCertificate().setNumber(Integer.parseInt(data));
        } else if (thisElement.equals(Medicals.START_DATE.value())) {
            getLastVersion().getCertificate().setStartDate(DateUtil.fromString(data));
        } else if (thisElement.equals(Medicals.EXPIRATION_DATE.value())) {
            getLastVersion().getCertificate().setExpirationDate(DateUtil.fromString(data));
        } else if (thisElement.equals(Medicals.REGISTERED_BY.value())) {
            getLastVersion().getCertificate().setRegisteredBy(data);
        } else if (thisElement.equals(Medicals.PACKAGE_TYPE.value())) {
            getLastVersion().getMedicalPackage().setPackageType(data);
        } else if (thisElement.equals(Medicals.AMOUNT.value())) {
            getLastVersion().getMedicalPackage().setAmount(Integer.parseInt(data));
        } else if (thisElement.equals(Medicals.PRICE.value())) {
            getLastVersion().getMedicalPackage().setPrice(new BigDecimal(data));
        } else if (thisElement.equals(Medicals.VALUE.value())) {
            getLastVersion().getDosage().setValue(Integer.parseInt(data));
        } else if (thisElement.equals(Medicals.PERIOD.value())) {
            getLastVersion().getDosage().setPeriod(data);
        }
    }

}
