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

package huix.glacier.api.registry.sync.remappers;

import huix.glacier.api.registry.RegistryIds;
import huix.glacier.api.registry.sync.RegistryHelperImpl;
import net.minecraft.Block;

public class BlockRegistryRemapper extends RegistryRemapper<Block> {
	public BlockRegistryRemapper() {
		super(RegistryHelperImpl.registriesGetter.getBlockRegistry(), RegistryIds.BLOCKS, "Block", "Blocks");
	}

//	@Override
//	public void remap() {
//		super.remap();
//	}

	@Override
	public int getMinId() {
		return 256;
	}
}
