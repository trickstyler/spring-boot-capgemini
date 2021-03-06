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
package com.capgemini.boot.trace.sample.video.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * An interface for a repository that can store Video objects and allow them to
 * be searched by title.
 */
@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {

    /**
     * Find all videos with a matching title
     * 
     * @param title video title (e.g., Video.name)
     * @return Collection of matching Video objects
     */
    Collection<Video> findByName(String title);

}
