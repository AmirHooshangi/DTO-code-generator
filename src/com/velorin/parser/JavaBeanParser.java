/*
 * Copyright (C) 2011 Amir Hooshangi.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published by
 * the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, see http://www.gnu.org/licenses or write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 *
 * You can contact Amir Hooshangi via Email
 * AmirHoshangi at Gmail
 *
 */

package com.velorin.parser;

import com.velorin.annotation.DTO;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author Amir Hooshangi
 * email: Amirhoshangi at Gmail
 */
public class JavaBeanParser implements BeanParser {

    public ArrayList<Field> getFields(Class<?> toBeParsedClass) {

        final Field[] unParsedFileds = toBeParsedClass.getDeclaredFields();
        final ArrayList<Field> parsedFields = new ArrayList<Field>();
        for (int i = 0; i < unParsedFileds.length; i++) {
            if (unParsedFileds[i].getAnnotation(DTO.class) == null) {

            } else {
                parsedFields.add(unParsedFileds[i]);
            }
        }
        return parsedFields;
    }
}
