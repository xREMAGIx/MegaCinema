/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCControllers;

/**
 *
 * @author Huynh Ha Vy
 */
import java.util.ArrayList;

public enum CustomerType {
	VANG_LAI,THANH_VIEN,VIP,VVIP;

	@Override
	public String toString() {
		switch (this) {
		case VANG_LAI:
			return "Vãng Lai";
		case THANH_VIEN:
			return "Thành Viên";
		case VIP:
			return "VIP";
                case VVIP:
                        return "VVIP";
                }
		return super.toString();
	}	
}

