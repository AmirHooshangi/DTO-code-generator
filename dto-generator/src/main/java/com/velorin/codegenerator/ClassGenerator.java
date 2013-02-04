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

package com.velorin.codegenerator;

import com.sun.codemodel.JClassAlreadyExistsException;

import java.io.IOException;

/**
 * @author Amir Hooshangi
 *         email: Amirhoshangi at Gmail
 */
public interface ClassGenerator {

    void generateDTOClass(Class<?> toBeParsedClass, String packageName, String filePath) throws JClassAlreadyExistsException, IOException;

    void generateDTOUtilClass(Class<?> bean, Class<?> beanDTO, String packageName, String filePath) throws JClassAlreadyExistsException, IOException;

}
