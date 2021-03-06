package info.nightscout.androidaps.plugins.pump.medtronic.comm;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import info.nightscout.androidaps.plugins.pump.common.utils.ByteUtil;
import info.nightscout.androidaps.plugins.pump.medtronic.data.dto.PumpSettingDTO;
import info.nightscout.androidaps.plugins.pump.medtronic.defs.MedtronicCommandType;
import info.nightscout.androidaps.plugins.pump.medtronic.defs.MedtronicDeviceType;
import info.nightscout.androidaps.plugins.pump.medtronic.util.MedtronicUtil;

/**
 * Created by andy on 1/30/19.
 */
public class MedtronicConverterUTest {

    MedtronicConverter converter = new MedtronicConverter();


    // 00 03 00 05 01 00 C8 00 A0 01 01 00 01 00 00 64 01 05 00 14 00 64 01 00 00
    //@Test
    public void testDecoding554() {
        byte[] data = ByteUtil
                .createByteArrayFromString("00 03 00 05 01 00 C8 00 A0 01 01 00 01 00 00 64 01 05 00 14 00 64 01 00 00");

        MedtronicUtil.setMedtronicPumpModel(MedtronicDeviceType.Medtronic_554_Veo);

        Map<String, PumpSettingDTO> settings = (Map<String, PumpSettingDTO>) converter.convertResponse(
                MedtronicCommandType.Settings, data);

        for (PumpSettingDTO pumpSettingDTO : settings.values()) {
            System.out.println("" + pumpSettingDTO.key + " = " + pumpSettingDTO.value);
        }

        // byte[] data = new byte[] { 00 03 00 05 01 00 C8 00 A0 01 01 00 01 00 00 64 01 05 00 14 00 64 01 00 00 };
    }


    //@Test
    public void testLocale() {
        Locale l = new Locale("en", "IE");

        Locale.setDefault(l);

        Date date = new Date();

        System.out.println("Date: toLocaleString: " + date.toLocaleString());
        System.out.println("Date: toString: " + date.toString());
        System.out.println("Date: toGMTString: " + date.toGMTString());


        for (String isoCountry : Locale.getISOCountries()) {
            //System.out.println("ISO country: " + isoCountry);
        }
    }

}
