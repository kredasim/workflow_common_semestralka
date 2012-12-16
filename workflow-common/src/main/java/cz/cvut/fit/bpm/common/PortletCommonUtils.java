/**
 * 
 */
package cz.cvut.fit.bpm.common;

import java.util.List;

import cz.cvut.fit.bpm.api.dto.UnitRoleDto;

/**
 * Common utility stuff for portlets.
 * @author Simeon Kredatus
 *
 */
public class PortletCommonUtils {

	/**
	 * Iterates over the list of {@link UnitRoleDto} and returns the one, which has role named roleName.
	 * @param roles
	 * @param roleName
	 * @return
	 */
	public static UnitRoleDto getUnitRoleByName(List<UnitRoleDto> roles, String roleName) {
		for (UnitRoleDto role : roles) {
			if (role.getRole().getName().equals(roleName)) {
				return role;
			}
		}
		return null;
	}
}
