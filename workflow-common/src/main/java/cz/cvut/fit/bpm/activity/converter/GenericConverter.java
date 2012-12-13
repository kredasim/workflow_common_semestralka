/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.activity.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public abstract class GenericConverter<D, P> implements Converter<D, P> {

    abstract public P convert(D dto);

    /**
     * Converts a list of DTOs to a list of PTOs using the
     *
     * @param dtos the list of DTOs
     *
     * @return list of PTOs
     */
    public List<P> convertList(List<D> dtos) {
        List<P> ptos = new ArrayList<P>();
        for (D dto : dtos) {
            ptos.add(convert(dto));
        }

        return ptos;
    }
}