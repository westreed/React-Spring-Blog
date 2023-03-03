import Plugin from '@ckeditor/ckeditor5-core/src/plugin';
import ButtonView from '@ckeditor/ckeditor5-ui/src/button/buttonview';

class Publish extends Plugin {
    init() {
    const editor = this.editor;
    
        editor.ui.componentFactory.add('Publish', locale => {
            const view = new ButtonView(locale);
    
            view.set({
                class: 'ck-publish',
                label: '발행',
                withText: true,
                // icon: TemplatePreviewIcon,
                tooltip: false
            });

            view.on("execute", (e) => {
                console.log("발행버튼 클릭함.");
            });
    
            return view;
        });
    }
}

export default Publish;