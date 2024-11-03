/*
 * Copyright (c) 2020 - 2024 Legacy Fabric
 * Copyright (c) 2016 - 2022 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package huix.glacier.api.registry.sync.compat;


import huix.glacier.api.registry.util.RegistryEventsHolder;
import huix.glacier.util.Identifier;

import java.util.Map;

public interface SimpleRegistryCompat<K, V> extends Iterable<V> {
	RegistryEventsHolder<V> getEventHolder();

	void setEventHolder(RegistryEventsHolder<V> eventsHolder);

	IdListCompat<V> getIds();

	Map<V, K> getObjects();

	void setIds(IdListCompat<V> idList);

	IdListCompat<V> createIdList();

	int getRawID(V object);

	K getKey(V object);

	V getValue(Object key);

	V register(int i, Object key, V value);

	default KeyType getKeyType() {
		return KeyType.GLACIER;
	}

	default K toKeyType(Object key) {
        return switch (this.getKeyType()) {
            case GLACIER -> (K) (key instanceof Identifier ? key : new Identifier(key.toString()));
            case JAVA -> (K) key.toString();
        };

    }

	enum KeyType {
		GLACIER,
		JAVA
	}
}
