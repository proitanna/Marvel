import androidx.lifecycle.LiveData
import com.tergeo.bugs.domain.repository.HeroRepository
import com.tergeo.bugs.domain.entity.HeroModel

interface HeroListInteractor {
    fun getHeroes(): LiveData<List<HeroModel>>
}

class HeroListInteractorImpl(
    private val heroRepository: HeroRepository
) : HeroListInteractor {

    override fun getHeroes(): LiveData<List<HeroModel>> =
        heroRepository.getHeroList()

}