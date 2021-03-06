/*
* Copyright 2015 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.capgemini.boot.core.factory.internal;

import com.capgemini.boot.core.factory.SettingsResolver;
import org.springframework.beans.FatalBeanException;
import org.springframework.boot.bind.PropertiesConfigurationFactory;
import org.springframework.core.env.ConfigurableEnvironment;

public class SpringBootSettingsResolver implements SettingsResolver {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T resolveSettings(Class<T> settingsClass, String prefix, ConfigurableEnvironment environment) {
        try {
            T newSettings = (T) Class.forName(settingsClass.getName()).newInstance();
    
            PropertiesConfigurationFactory<Object> factory = new PropertiesConfigurationFactory<Object>(newSettings);
            factory.setTargetName(prefix);
            factory.setPropertySources(environment.getPropertySources());
            factory.setConversionService(environment.getConversionService());
            factory.bindPropertiesToTarget();
    
            return newSettings;
        } catch (Exception ex) {
            throw new FatalBeanException("Could not bind DataSourceSettings properties", ex);
        }
    }

}
